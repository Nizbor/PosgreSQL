package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sillysociety.org.models.Role;
import sillysociety.org.service.RoleService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/role/")
public class RoleRestController {
    @Autowired
    private RoleService roleService;

    @PostMapping(path = "add")
    public Role add(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @GetMapping(path = "get")
    public List<Role> get() {
        return roleService.getAllRoles();
    }

    @PutMapping(path = "update")
    public Role update(@RequestBody Role role) {
        return roleService.updateRole(role);
    }

    @DeleteMapping(path = "delete")
    public void delete(@RequestBody Role role) {
        roleService.deleteRole(role);
    }
}
