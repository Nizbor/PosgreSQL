package sillysociety.org.repository;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.UserFile;

public interface UserFileRepository extends CrudRepository<UserFile, Integer> {
}
