package sillysociety.org.repository;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.ReactionMessage;

public interface ReactionMessageRepository extends CrudRepository<ReactionMessage, Integer> {
}
