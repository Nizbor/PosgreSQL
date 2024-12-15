package sillysociety.org.repository;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByLogin(String login);
}
