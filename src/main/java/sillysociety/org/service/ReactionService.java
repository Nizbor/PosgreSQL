package sillysociety.org.service;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.Reaction;

import java.util.List;

public interface ReactionService{
    Reaction addReaction(Reaction reaction);
    void deleteReaction(Reaction reaction);
    Reaction getReactionById(Integer id);
    List<Reaction> getAllReactions();
    Reaction updateReaction(Reaction reaction);

}
