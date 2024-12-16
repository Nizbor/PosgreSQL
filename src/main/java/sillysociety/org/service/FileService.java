package sillysociety.org.service;

import sillysociety.org.models.File;

import java.util.List;


public interface FileService{
    File addFile(File file);
    void deleteFile(File file);
    File getFileById(Integer id);
    List<File> getAllFiles();
    File updateFile(File file);



}
