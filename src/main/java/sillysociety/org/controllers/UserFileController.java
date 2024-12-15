package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sillysociety.org.models.UserFile;
import sillysociety.org.service.UserFileService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user_file/")
public class UserFileController {
    @Autowired
    private UserFileService userFileService;

    @PostMapping(path = "add")
    public UserFile add(@RequestBody UserFile userFile) {
        return userFileService.addUserFile(userFile);
    }

    @GetMapping(path = "get")
    public List<UserFile> get() {
        return userFileService.findAllUserFiles();
    }

    @PutMapping(path = "update")
    public UserFile update(@RequestBody UserFile userFile) {
        return userFileService.updateUserFile(userFile);
    }

    @DeleteMapping(path = "delete")
    public void delete(@RequestBody UserFile userFile) {
        userFileService.deleteUserFile(userFile);
    }
}
