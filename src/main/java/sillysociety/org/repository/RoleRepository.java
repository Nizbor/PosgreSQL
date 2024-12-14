package sillysociety.org.repository;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
