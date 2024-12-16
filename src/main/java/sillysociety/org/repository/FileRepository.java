package sillysociety.org.repository;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.File;

public interface FileRepository extends CrudRepository<File, Integer> {
}
