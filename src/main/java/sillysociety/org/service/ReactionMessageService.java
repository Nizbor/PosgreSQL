package sillysociety.org.service;

import sillysociety.org.models.ReactionMessage;

import java.util.List;

public interface ReactionMessageService {

    ReactionMessage addReactionMessage(ReactionMessage reactionMessage);
    void deleteReactionMessage(ReactionMessage reactionMessage);
    ReactionMessage getReactionMessageById(Integer id);
    List<ReactionMessage> getAllReactionMessages();
    ReactionMessage updateReactionMessage(ReactionMessage reactionMessage);

}
