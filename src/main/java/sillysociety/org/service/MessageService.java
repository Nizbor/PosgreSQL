package sillysociety.org.service;

import sillysociety.org.models.Message;

import java.util.List;

public interface MessageService {
    Message addMessage(Message message);
    void deleteMessage(Message message);
    Message getMessageById(Integer messageId);
    List<Message> getAllMessages();
    Message updateMessage(Message message);

    List<Message> getMessagesByChatId(Integer chatId);
    List<Message> getNewMessages(Integer lastMessageId, Integer userId);
}
