package sillysociety.org.repository;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.Message;
import sillysociety.org.models.MessageId;

public interface MessageRepository extends CrudRepository<Message, MessageId> {
}
