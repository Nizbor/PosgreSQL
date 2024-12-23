package sillysociety.org.controllers.messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import sillysociety.org.config.MyUserDetails;
import sillysociety.org.models.Chat;
import sillysociety.org.models.Message;
import sillysociety.org.models.User;
import sillysociety.org.models.UserChat;
import sillysociety.org.service.ChatService;
import sillysociety.org.service.MessageService;
import sillysociety.org.service.UserChatService;
import sillysociety.org.service.UserService;

import java.time.OffsetDateTime;
import java.util.*;

@RestController
@RequestMapping(path = "/messenger/api")
public class ApiMessenger {
    @Autowired
    private ChatService chatService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserChatService userChatService;
    @Autowired
    private UserService userService;

    @PostMapping(path = "/createChat")
    public ResponseEntity<?> createChat(Authentication auth, @RequestBody Integer newUserId) {
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        User authUser = userDetails.getUser();
        User user = userService.getUserById(newUserId);
        String title = user.getLastName() + " " + user.getFirstName() + (user.getFatherland() == null ? " & " : (user.getFatherland()) + " & ") +
                authUser.getLastName() + " " + authUser.getFirstName() + (authUser.getFatherland() == null ? "" : (authUser.getFatherland()));

        Chat chat = new Chat();
        chat.setTitle(title);
        chat = chatService.addChat(chat);

        Map<String, Integer> response = new HashMap<>();
        response.put("chatId", chat.getId());
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/addUsersToChat")
    public ResponseEntity<?> addUsersToChat(Authentication auth, @RequestBody Integer[] ids) {
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        Integer uid = userDetails.getId();

        ArrayList<Integer> newIds = new ArrayList<>(Arrays.asList(ids));
        newIds.add(0, uid);
        Integer chatId = newIds.get(newIds.size() - 1);
        newIds.remove(newIds.size() - 1);
        for (Integer userId : newIds) {
            UserChat userChat = new UserChat();
            userChat.setChat(chatService.getChatById(chatId));
            userChat.setUser(userService.getUserById(userId));
            userChatService.addUserChat(userChat);
        }
        Map<String, String> response = new HashMap<>();
        response.put("status", "ok");
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/sendMessage")
    public ResponseEntity<?> sendMessage(Authentication auth, @RequestBody String[] chatIdWithText) {
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();

        List<String> myList = List.of(chatIdWithText);

        Integer chatId = Integer.parseInt(myList.getFirst());
        String text = myList.getLast();

        Message message = new Message();
        message.setFrom(userDetails.getUser());
        message.setChat(chatService.getChatById(chatId));
        message.setTime(OffsetDateTime.now());
        message.setTextMessage(text);
        message = messageService.addMessage(message);

        Map<String, Message> response = new HashMap<>();
        response.put("message", message);

        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/getMessages")
    public List<Message> getMessages(Authentication auth, @RequestParam Integer lastMessageId) {
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        return messageService.getNewMessages(lastMessageId, userDetails.getId());
    }

    @GetMapping(path = "/checkChatWithUser")
    public Integer checkChatWithUser(Authentication auth, @RequestParam Integer userId) {
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();

        List<Integer> userIds = List.of(userDetails.getId(), userId);
        List<Integer> chatIds = userChatService.findChatsByUserIds(userIds, 2);

        if (!chatIds.isEmpty()) {
            return chatIds.get(0);
        }

        return -1;
    }
}
