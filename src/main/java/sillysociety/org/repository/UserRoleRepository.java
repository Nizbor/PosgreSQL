package sillysociety.org.repository;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
}
