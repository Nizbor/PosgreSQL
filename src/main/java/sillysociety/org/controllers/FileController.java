package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sillysociety.org.config.MyUserDetails;

import sillysociety.org.models.File;

import sillysociety.org.models.UserFile;
import sillysociety.org.service.FileService;
import sillysociety.org.service.StorageService;
import sillysociety.org.service.UserFileService;
import sillysociety.org.service.UserService;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/file/")
public class FileController {
    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private UserFileService userFileService;

    @PostMapping(path = "add")
    public File add(@RequestParam("file") MultipartFile file) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();

        //на сервер грузим
        String filename = storageService.store(file, userDetails.getUser());

        File tmpFile = fileService.getFileByNameAndUserId(file.getOriginalFilename(), userDetails.getUser().getId());
        if (tmpFile != null) {
            fileService.updateVersionAndTime(tmpFile.getId(), tmpFile.getVersion() + 1, OffsetDateTime.now());
            return fileService.getFileById(tmpFile.getId());
        }
        File fileEntity = new File();
        fileEntity.setName(file.getOriginalFilename());
        fileEntity.setAuthor(userDetails.getUser());
        fileEntity.setEditDate(OffsetDateTime.now());
        fileEntity.setVersion(1);
        fileEntity.setPath(filename);
        fileEntity.setSize(file.getSize());

        fileEntity = fileService.addFile(fileEntity);

        UserFile userFile = new UserFile();
        userFile.setFile(fileEntity);
        userFile.setUser(userDetails.getUser());

        try {
            userFile = userFileService.addUserFile(userFile);
        } catch (Exception e) {
            fileService.deleteFile(fileEntity);
            e.printStackTrace();
        }

        return fileEntity;
    }


    @PostMapping(path = "multiple-add")
    public List<File> multipleAdd(@RequestParam("files") MultipartFile[] files) {
        List<File> fileEntities = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                fileEntities.add(add(file)); // Вызываем метод add() для каждого файла
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileEntities;
    }

    @GetMapping(path = "get")
    public List<File> get() {
        return fileService.getAllFiles();
    }

    @PutMapping(path = "update")
    public File update(@RequestBody File file) {
        fileService.deleteFile(file);
        return fileService.updateFile(file);
    }

    @DeleteMapping(path = "delete")
    public void delete(@RequestBody File file) {
        fileService.deleteFile(file);
    }

    @GetMapping("download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer id) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();

        // Ищем файл в базе данных
        File file = fileService.getFileById(id);

        // Загружаем файл из хранилища по пути
        Resource resource = storageService.loadAsResource(file.getPath());

        String mimeType = Files.probeContentType(Path.of(file.getPath()));
        if (mimeType == null) {
            mimeType = "application/octet-stream"; // Универсальный тип, если MIME-тип не определён
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename*=UTF-8''" + URLEncoder.encode(file.getName(), StandardCharsets.UTF_8))
                .header(HttpHeaders.CONTENT_TYPE, mimeType)
                .body(resource);
    }

}
