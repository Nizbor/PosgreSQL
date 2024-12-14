package sillysociety.org.repository;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.MessageFile;

public interface MessageFileRepository extends CrudRepository<MessageFile, Integer> {
}
