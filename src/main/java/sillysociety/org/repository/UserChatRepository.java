package sillysociety.org.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import sillysociety.org.models.UserChat;

import java.util.List;

public interface UserChatRepository extends CrudRepository<UserChat, Integer> {
    @Query(value = "SELECT uc.chat.id FROM UserChat AS uc WHERE uc.user.id IN (:userIds) GROUP BY uc.chat.id HAVING COUNT(DISTINCT uc.user.id) = :userCount")
    @Transactional
    List<Integer> findChatsByUserIds(@Param("userIds") List<Integer> userIds, @Param("userCount") Integer userCount);
}
