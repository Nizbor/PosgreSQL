package sillysociety.org.controllers.messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sillysociety.org.config.MyUserDetails;
import sillysociety.org.models.Chat;
import sillysociety.org.models.Message;
import sillysociety.org.models.User;
import sillysociety.org.service.ChatService;
import sillysociety.org.service.MessageService;
import sillysociety.org.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(path = "/messenger")
public class MainMessengerController {
    @Autowired
    private ChatService chatService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String index(Model model, Authentication auth) {
        // Getting details of authorized user for next steps
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        model.addAttribute("currentUserId", userDetails.getId());

        // Find all users for dropbox and remove from list authorized user
        List<User> users = userService.getAllUsers();
        users.removeIf(user -> Objects.equals(user.getId(), userDetails.getId()));
        model.addAttribute("users", users);

        // Find all chats for authorized user
        List<Chat> chats = chatService.getChatsByUID(userDetails.getId());
        model.addAttribute("chats", chats);

        // Find all messages for authorized user
        Map<Integer, List<Message>> messages = new HashMap<>();
        for (Chat chat : chats) {
            messages.put(chat.getId(), messageService.getMessagesByChatId(chat.getId()));
        }

        model.addAttribute("messages", messages);

        return "messenger/messenger";
    }
}
