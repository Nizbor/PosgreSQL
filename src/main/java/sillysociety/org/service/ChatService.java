package sillysociety.org.service;

import sillysociety.org.models.Chat;

import java.util.List;

public interface ChatService{
    Chat addChat(Chat chat);
    void deleteChat(Chat chat);
    Chat getChatById(Integer id);
    List<Chat> getAllChats();
    Chat updateChat(Chat chat);
}
