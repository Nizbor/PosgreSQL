package sillysociety.org.repository;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.Reaction;

public interface ReactionRepository extends CrudRepository<Reaction, Integer> {
}
