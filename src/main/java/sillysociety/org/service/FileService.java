package sillysociety.org.service;

import sillysociety.org.models.File;

import java.time.OffsetDateTime;
import java.util.List;


public interface FileService{
    File addFile(File file);
    void deleteFile(File file);
    File getFileById(Integer id);
    List<File> getAllFiles();
    File updateFile(File file);

    List<File> getAllAvailableFiles(Integer id);

    File getFileByNameAndUserId(String fileName, Integer userId);
    void updateVersionAndTime(Integer id, Integer version, OffsetDateTime timestamp);
}
