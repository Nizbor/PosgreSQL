package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sillysociety.org.models.Chat;
import sillysociety.org.models.User;
import sillysociety.org.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user/")
public class UserRestController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "add")
    public User add(@RequestBody User user) {
        return userService.addUser(user);
    }
    @GetMapping(path = "get")
    public List<User> get() {
        return userService.getAllUsers();
    }
    @PutMapping(path = "update")
    public User update(@RequestBody User user) {
        return userService.updateUser(user);
    }
    @DeleteMapping(path = "delete")
    public void delete(@RequestBody User user) {
        userService.deleteUser(user);
    }
}
