package sillysociety.org.service;

import sillysociety.org.models.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole addUserRole(UserRole userRole);
    void deleteUserRole(UserRole userRole);
    UserRole getUserRoleById(Integer id);
    List<UserRole> getAllUserRoles();
    UserRole updateUserRole(UserRole userRole);


}
