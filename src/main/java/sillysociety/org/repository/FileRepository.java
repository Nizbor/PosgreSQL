package sillysociety.org.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.File;

import java.util.List;
import java.util.Optional;

public interface FileRepository extends CrudRepository<File, Integer> {
    Optional<File> getFileByName(String name);

    @Query("UPDATE File AS f SET f.version = ?2 WHERE f.id = ?1")
    @Transactional
    @Modifying
    void updateVersion(Integer id, Integer version);

    @Query("SELECT f FROM File AS f JOIN UserFile AS uf ON f.id = uf.file.id WHERE uf.user.id = ?1")
    @Transactional
    @Modifying
    List<File> getAvailableFiles(Integer id);
}
