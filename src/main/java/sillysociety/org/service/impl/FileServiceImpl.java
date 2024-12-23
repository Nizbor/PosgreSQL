package sillysociety.org.service.impl;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sillysociety.org.models.File;
import sillysociety.org.repository.FileRepository;
import sillysociety.org.service.FileService;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

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
    public File getFileById(Integer id) {
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

    @Override
    public List<File> getAllAvailableFiles(Integer id) {
        return fileRepository.getAvailableFiles(id);
    }

    @Override
    public File getFileByNameAndUserId(String fileName, Integer userId) {
        return fileRepository.getFileByNameAndUserId(fileName, userId).orElse(null);
    }

    @Override
    public void updateVersionAndTime(Integer id, Integer version, OffsetDateTime timestamp) {
        fileRepository.updateVersionAndTime(id, version, timestamp);
    }
}
