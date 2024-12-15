package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sillysociety.org.models.ReactionMessage;
import sillysociety.org.service.ReactionMessageService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/reaction_message/")
public class ReactionMessageController {
    @Autowired
    private ReactionMessageService reactionMessageService;

    @PostMapping(path = "add")
    public ReactionMessage add(@RequestBody ReactionMessage reactionMessage) {
        return reactionMessageService.addReactionMessage(reactionMessage);
    }

    @GetMapping(path = "get")
    public List<ReactionMessage> get() {
        return reactionMessageService.getAllReactionMessages();
    }

    @PutMapping(path = "update")
    public ReactionMessage update(@RequestBody ReactionMessage reactionMessage) {
        return reactionMessageService.updateReactionMessage(reactionMessage);
    }

    @DeleteMapping(path = "delete")
    public void delete(@RequestBody ReactionMessage reactionMessage) {
        reactionMessageService.deleteReactionMessage(reactionMessage);
    }
}