package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sillysociety.org.models.Chat;
import sillysociety.org.service.ChatService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/chat/")
public class ChatRestController {
    @Autowired
    private ChatService chatService;

    @PostMapping(path = "add")
    public Chat add(@RequestBody Chat chat) {
        return chatService.addChat(chat);
    }

    @GetMapping(path = "get")
    public List<Chat> get() {
        return chatService.getAllChats();
    }

    @PutMapping(path = "update")
    public Chat update(@RequestBody Chat chat) {
        return chatService.updateChat(chat);
    }

    @DeleteMapping(path = "delete")
    public void delete(@RequestBody Chat chat) {
        chatService.deleteChat(chat);
    }
}
