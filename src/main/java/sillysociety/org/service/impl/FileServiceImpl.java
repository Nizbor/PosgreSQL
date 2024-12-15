package sillysociety.org.service.impl;

import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sillysociety.org.models.File;
import sillysociety.org.models.FileId;
import sillysociety.org.repository.FileRepository;
import sillysociety.org.service.FileService;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;

    @Override
    public File addFile(File file) {
        return fileRepository.save(file);
    }

    @Override
    public void deleteFile(File file) {
        fileRepository.delete(file);
    }

    @Override
    public File getFileById(FileId id) {
        return fileRepository.findById(id).orElse(null);
    }

    @Override
    public List<File> getAllFiles() {
        return (List<File>) fileRepository.findAll();
    }

    @Override
    public File updateFile(File file) {
        return fileRepository.save(file);
    }

}
