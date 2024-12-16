package sillysociety.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sillysociety.org.models.MessageFile;
import sillysociety.org.repository.MessageFileRepository;
import sillysociety.org.service.MessageFileService;

import java.util.List;

@Service
public class MessageFileServiceImpl implements MessageFileService {
    @Autowired
    private MessageFileRepository messageFileRepository;

    @Override
    public MessageFile addMessageFile(MessageFile messageFile) {
        return messageFileRepository.save(messageFile);
    }

    @Override
    public void deleteMessageFile(MessageFile messageFile) {
        messageFileRepository.delete(messageFile);
    }

    @Override
    public MessageFile getMessageFileById(Integer id) {
        return messageFileRepository.findById(id).orElse(null);
    }

    @Override
    public List<MessageFile> getMessageFiles() {
        return (List<MessageFile>) messageFileRepository.findAll();
    }

    @Override
    public MessageFile updateMessageFile(MessageFile messageFile) {
        return messageFileRepository.save(messageFile);
    }
}
