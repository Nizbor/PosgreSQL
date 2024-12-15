package sillysociety.org.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.UserRole;

import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
    @Query("SELECT r.name FROM UserRole AS ur JOIN Role AS r ON ur.role.id = r.id WHERE ur.user.id = ?1")
    @Transactional
    @Modifying
    List<String> getRolesByUserId(Integer userId);
}
