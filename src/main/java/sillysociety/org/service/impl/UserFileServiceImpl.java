package sillysociety.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sillysociety.org.models.UserFile;
import sillysociety.org.repository.UserFileRepository;
import sillysociety.org.service.UserFileService;

import java.util.List;

@Service
public class UserFileServiceImpl implements UserFileService {
    @Autowired
    private UserFileRepository userFileRepository;
    @Override
    public UserFile addUserFile(UserFile userFile) {
        return userFileRepository.save(userFile);
    }

    @Override
    public void deleteUserFile(UserFile userFile) {
        userFileRepository.delete(userFile);
    }

    @Override
    public UserFile findUserFileById(Integer id) {
        return userFileRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserFile> findAllUserFiles() {
        return (List<UserFile>) userFileRepository.findAll();
    }

    @Override
    public UserFile updateUserFile(UserFile userFile) {
        return userFileRepository.save(userFile);
    }
}
