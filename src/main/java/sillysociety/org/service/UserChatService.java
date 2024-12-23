package sillysociety.org.service;

import sillysociety.org.models.UserChat;

import java.util.List;

public interface UserChatService {
    UserChat addUserChat(UserChat user);
    void deleteUserChat(UserChat user);
    UserChat getUserChatById(Integer id);
    List<UserChat> getAllUserChats();
    UserChat updateUserChat(UserChat user);

    List<Integer> findChatsByUserIds(List<Integer> userIds, Integer userCount);
}
