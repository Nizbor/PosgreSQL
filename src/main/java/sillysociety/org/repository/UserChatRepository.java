package sillysociety.org.repository;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.UserChat;

public interface UserChatRepository extends CrudRepository<UserChat, Integer> {
}
