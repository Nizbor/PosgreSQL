package sillysociety.org.repository;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.File;
import sillysociety.org.models.FileId;

public interface FileRepository extends CrudRepository<File, FileId> {
}
