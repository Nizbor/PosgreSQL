package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sillysociety.org.models.MessageFile;
import sillysociety.org.service.MessageFileService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/message_file/")
public class MessageFileController {
    @Autowired
    private MessageFileService messageFileService;

    @PostMapping(path = "add")
    public MessageFile add(@RequestBody MessageFile messageFile) {
        return messageFileService.addMessageFile(messageFile);
    }

    @GetMapping(path = "get")
    public List<MessageFile> get() {
        return messageFileService.getMessageFiles();
    }

    @PutMapping(path = "update")
    public MessageFile update(@RequestBody MessageFile messageFile) {
        return messageFileService.updateMessageFile(messageFile);
    }

    @DeleteMapping(path = "delete")
    public void delete(@RequestBody MessageFile messageFile) {
        messageFileService.deleteMessageFile(messageFile);
    }
}
