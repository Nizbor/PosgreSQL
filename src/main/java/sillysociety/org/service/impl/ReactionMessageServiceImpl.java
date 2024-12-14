package sillysociety.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sillysociety.org.models.ReactionMessage;
import sillysociety.org.repository.ReactionMessageRepository;
import sillysociety.org.service.ReactionMessageService;

import java.util.List;

@Service
public class ReactionMessageServiceImpl implements ReactionMessageService {
    @Autowired
    private ReactionMessageRepository reactionMessageRepository;

    @Override
    public ReactionMessage addReactionMessage(ReactionMessage reactionMessage) {
        return reactionMessageRepository.save(reactionMessage);
    }

    @Override
    public void deleteReactionMessage(ReactionMessage reactionMessage) {
        reactionMessageRepository.delete(reactionMessage);
    }

    @Override
    public ReactionMessage getReactionMessageById(Integer id) {
        return reactionMessageRepository.findById(id).orElse(null);
    }

    @Override
    public List<ReactionMessage> getAllReactionMessages() {
        return (List<ReactionMessage>) reactionMessageRepository.findAll();
    }

    @Override
    public ReactionMessage updateReactionMessage(ReactionMessage reactionMessage) {
        return reactionMessageRepository.save(reactionMessage);
    }
}
