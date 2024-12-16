package sillysociety.org.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import sillysociety.org.models.User;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
    void init();

    String store(MultipartFile file, User user);
    Stream<Path> loadAll();
    Path load(String filename);
    Resource loadAsResource(String filename);
    void deleteAll();

}
