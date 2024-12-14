package sillysociety.org.service;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void deleteUser(User user);
    User getUserById(Integer id);
    List<User> getAllUsers();
    User updateUser(User user);
}
