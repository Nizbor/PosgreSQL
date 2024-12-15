package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sillysociety.org.models.File;
import sillysociety.org.service.FileService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/file/")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping(path = "add")
    public File add(@RequestBody File file) {
        return fileService.addFile(file);
    }

    @GetMapping(path = "get")
    public List<File> get() {
        return fileService.getAllFiles();
    }

    @PutMapping(path = "update")
    public File update(@RequestBody File file) {
        return fileService.updateFile(file);
    }

    @DeleteMapping(path = "delete")
    public void delete(@RequestBody File file) {
        fileService.deleteFile(file);
    }
}
