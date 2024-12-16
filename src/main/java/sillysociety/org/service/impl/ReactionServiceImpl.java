package sillysociety.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sillysociety.org.models.Reaction;
import sillysociety.org.repository.ReactionRepository;
import sillysociety.org.service.ReactionService;

import java.util.List;

@Service
public class ReactionServiceImpl implements ReactionService {
    @Autowired
    private ReactionRepository reactionRepository;

    @Override
    public Reaction addReaction(Reaction reaction) {
        return reactionRepository.save(reaction);
    }

    @Override
    public void deleteReaction(Reaction reaction) {
        reactionRepository.delete(reaction);
    }

    @Override
    public Reaction getReactionById(Integer id) {
        return reactionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reaction> getAllReactions() {
        return (List<Reaction>) reactionRepository.findAll();
    }

    @Override
    public Reaction updateReaction(Reaction reaction) {
        return reactionRepository.save(reaction);
    }
}
