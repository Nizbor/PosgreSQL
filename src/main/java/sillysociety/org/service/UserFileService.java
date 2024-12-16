package sillysociety.org.service;

import sillysociety.org.models.UserFile;

import java.util.List;

public interface UserFileService {
    UserFile addUserFile(UserFile userFile);
    void deleteUserFile(UserFile userFile);
    UserFile findUserFileById(Integer id);
    List<UserFile> findAllUserFiles();
    UserFile updateUserFile(UserFile userFile);
}
