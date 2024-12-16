package sillysociety.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sillysociety.org.models.UserRole;
import sillysociety.org.repository.UserRoleRepository;
import sillysociety.org.service.UserRoleService;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole addUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public void deleteUserRole(UserRole userRole) {
        userRoleRepository.delete(userRole);
    }

    @Override
    public UserRole getUserRoleById(Integer id) {
        return userRoleRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserRole> getAllUserRoles() {
        return (List<UserRole>) userRoleRepository.findAll();
    }

    @Override
    public UserRole updateUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public List<String> getRolesByUserId(Integer userId) {
        return userRoleRepository.getRolesByUserId(userId);
    }
}
