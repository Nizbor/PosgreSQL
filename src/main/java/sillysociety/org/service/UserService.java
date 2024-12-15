package sillysociety.org.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import sillysociety.org.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User addUser(User user);
    void deleteUser(User user);
    User getUserById(Integer id);
    List<User> getAllUsers();
    User updateUser(User user);
}
