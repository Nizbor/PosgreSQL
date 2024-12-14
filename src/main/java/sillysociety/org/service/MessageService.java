package sillysociety.org.service;

import sillysociety.org.models.Message;
import sillysociety.org.models.MessageId;

import java.util.List;

public interface MessageService {
    Message addMessage(Message message);
    void deleteMessage(Message message);
    Message getMessageById(MessageId messageId);
    List<Message> getAllMessages();
    Message updateMessage(Message message);

}
