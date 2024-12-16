package sillysociety.org.repository;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {
}
