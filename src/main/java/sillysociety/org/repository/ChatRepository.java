package sillysociety.org.repository;


import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.Chat;

public interface ChatRepository extends CrudRepository<Chat, Integer> {

}
