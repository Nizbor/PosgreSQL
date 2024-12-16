package sillysociety.org.service;

import sillysociety.org.models.Role;

import java.util.List;

public interface RoleService {
    Role addRole(Role role);
    void deleteRole(Role role);
    Role getRoleById(Integer id);
    List<Role> getAllRoles();
    Role updateRole(Role role);
}
