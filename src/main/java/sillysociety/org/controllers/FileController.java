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
import sillysociety.org.models.FileId;
import sillysociety.org.models.User;

import sillysociety.org.service.FileService;
import sillysociety.org.service.StorageService;
import sillysociety.org.service.UserService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

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

    private Integer count = -1;

    @PostMapping(path = "add")
    @ResponseBody
    public File add(@RequestParam("file") MultipartFile file) {
        count++;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        String filename = storageService.store(file);
        User user = userService.getUserById(userDetails.getId());

        FileId fileId = new FileId();
        fileId.setId(count);
        fileId.setAuthor(userDetails.getId());


        File fileEntity = new File();
            fileEntity.setId(fileId);
            fileEntity.setAuthor(user);
            fileEntity.setName(file.getOriginalFilename());
            fileEntity.setEditDate(LocalDate.now());
            fileEntity.setVersion(1);
            fileEntity.setPath(filename);

        return fileService.addFile(fileEntity);
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
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        // Создаём составной идентификатор
        FileId fileId = new FileId();
        fileId.setId(id);
        fileId.setAuthor(userDetails.getId());
        // Ищем файл в базе данных
        File file = fileService.getFileById(fileId);
        // Загружаем файл из хранилища по пути
        Resource resource = storageService.loadAsResource(file.getPath());

        // Возвращаем файл как вложение
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getName() + "\"")
                .body(resource);
    }

}
