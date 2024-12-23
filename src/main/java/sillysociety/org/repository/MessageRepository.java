package sillysociety.org.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.Message;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    @Query("SELECT m FROM Message AS m WHERE m.chat.id = ?1")
    @Modifying
    @Transactional
    List<Message> getMessagesByChatId(Integer chatId);

    @Query("SELECT m FROM Message AS m JOIN Chat AS c ON m.chat.id = c.id JOIN UserChat AS uc ON (uc.chat.id = c.id AND uc.user.id = ?2) WHERE m.id > ?1")
    @Modifying
    @Transactional
    List<Message> getNewMessages(Integer lastMessageId, Integer userId);
}
