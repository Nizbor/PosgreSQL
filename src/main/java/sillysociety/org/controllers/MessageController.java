package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sillysociety.org.models.Message;
import sillysociety.org.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping(path = "add")
    public Message add(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

    @GetMapping(path = "get")
    public List<Message> get() {
        return messageService.getAllMessages();
    }

    @PutMapping(path = "update")
    public Message update(@RequestBody Message message) {
        return messageService.updateMessage(message);
    }

    @DeleteMapping(path = "delete")
    public void delete(@RequestBody Message message) {
        messageService.deleteMessage(message);
    }
}
