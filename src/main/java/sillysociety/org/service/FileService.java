package sillysociety.org.service;


import sillysociety.org.models.File;
import sillysociety.org.models.FileId;

import java.util.List;


public interface FileService{
    File addFile(File file);
    void deleteFile(File file);
    File getFileById(FileId id);
    List<File> getAllFiles();
    File updateFile(File file);
}
