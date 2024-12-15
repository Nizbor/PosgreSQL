package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sillysociety.org.models.Reaction;
import sillysociety.org.service.ReactionService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/reaction/")
public class ReactionController {
    @Autowired
    private ReactionService reactionService;

    @PostMapping(path = "add")
    public Reaction add(@RequestBody Reaction reaction) {
        return reactionService.addReaction(reaction);
    }

    @GetMapping(path = "get")
    public List<Reaction> get() {
        return reactionService.getAllReactions();
    }

    @PutMapping(path = "update")
    public Reaction update(@RequestBody Reaction reaction) {
        return reactionService.updateReaction(reaction);
    }

    @DeleteMapping(path = "delete")
    public void delete(@RequestBody Reaction reaction) {
        reactionService.deleteReaction(reaction);
    }
}
