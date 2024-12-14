package sillysociety.org.service;

import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.MessageFile;

import java.util.List;

public interface MessageFileService {

    MessageFile addMessageFile(MessageFile messageFile);
    void deleteMessageFile(MessageFile messageFile);
    MessageFile getMessageFileById(Integer id);
    List<MessageFile> getMessageFiles();
    MessageFile updateMessageFile(MessageFile messageFile);

}
