package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sillysociety.org.models.UserRole;
import sillysociety.org.service.UserRoleService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user_role/")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @PostMapping(path = "add")
    public UserRole add(@RequestBody UserRole userRole) {
        return userRoleService.addUserRole(userRole);
    }

    @GetMapping(path = "get")
    public List<UserRole> get() {
        return userRoleService.getAllUserRoles();
    }

    @PutMapping(path = "update")
    public UserRole update(@RequestBody UserRole userRole) {
        return userRoleService.updateUserRole(userRole);
    }

    @DeleteMapping(path = "delete")
    public void delete(@RequestBody UserRole userRole) {
        userRoleService.deleteUserRole(userRole);
    }
}
