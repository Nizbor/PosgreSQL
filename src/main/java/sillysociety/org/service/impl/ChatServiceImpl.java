package sillysociety.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sillysociety.org.models.Chat;
import sillysociety.org.repository.ChatRepository;
import sillysociety.org.service.ChatService;

import java.util.List;
@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chat addChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public void deleteChat(Chat chat) {
        chatRepository.delete(chat);
    }

    @Override
    public Chat getChatById(Integer id) {
        return chatRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chat> getAllChats() {
        return (List<Chat>) chatRepository.findAll();
    }

    @Override
    public Chat updateChat(Chat chat) {
        return chatRepository.save(chat);
    }
}
