package sillysociety.org.repository;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
