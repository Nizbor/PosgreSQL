package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sillysociety.org.models.UserChat;
import sillysociety.org.service.UserChatService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user_chat/")
public class UserChatController {
    @Autowired
    private UserChatService userChatService;

    @PostMapping(path = "add")
    public UserChat add(@RequestBody UserChat userChat) {
        return userChatService.addUserChat(userChat);
    }

    @GetMapping(path = "get")
    public List<UserChat> get() {
        return userChatService.getAllUserChats();
    }

    @PutMapping(path = "update")
    public UserChat update(@RequestBody UserChat userChat) {
        return userChatService.updateUserChat(userChat);
    }

    @DeleteMapping(path = "delete")
    public void delete(@RequestBody UserChat userChat) {
        userChatService.deleteUserChat(userChat);
    }
}
