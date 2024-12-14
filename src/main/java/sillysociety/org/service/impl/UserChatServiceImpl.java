package sillysociety.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sillysociety.org.models.UserChat;
import sillysociety.org.repository.UserChatRepository;
import sillysociety.org.service.UserChatService;

import java.util.List;
@Service
public class UserChatServiceImpl implements UserChatService {
    @Autowired
    private UserChatRepository userChatRepository;
    @Override
    public UserChat addUserChat(UserChat user) {
        return userChatRepository.save(user);
    }

    @Override
    public void deleteUserChat(UserChat user) {
        userChatRepository.delete(user);
    }

    @Override
    public UserChat getUserChatById(Integer id) {
        return userChatRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserChat> getAllUserChats() {
        return (List<UserChat>) userChatRepository.findAll();
    }

    @Override
    public UserChat updateUserChat(UserChat user) {
        return userChatRepository.save(user);
    }
}
