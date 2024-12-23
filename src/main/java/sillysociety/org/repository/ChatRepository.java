package sillysociety.org.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.Chat;

import java.util.List;

public interface ChatRepository extends CrudRepository<Chat, Integer> {
    @Query("SELECT c FROM Chat AS c JOIN UserChat AS uc ON c.id = uc.chat.id WHERE uc.user.id = ?1")
    @Transactional
    @Modifying
    List<Chat> getChatsByUID(Integer UID);
}
