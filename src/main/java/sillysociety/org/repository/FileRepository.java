package sillysociety.org.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sillysociety.org.models.File;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface FileRepository extends CrudRepository<File, Integer> {
    @Query("SELECT f From File AS f WHERE f.name = ?1 AND f.author.id = ?2")
    @Transactional
    Optional<File> getFileByNameAndUserId(String name, Integer userId);

    @Query("UPDATE File AS f SET f.version = ?2, f.editDate = ?3 WHERE f.id = ?1")
    @Modifying(clearAutomatically = true)
    @Transactional
    void updateVersionAndTime(Integer id, Integer version, OffsetDateTime timestamp);

    @Query("SELECT f FROM File AS f JOIN UserFile AS uf ON f.id = uf.file.id WHERE uf.user.id = ?1")
    @Transactional
    @Modifying
    List<File> getAvailableFiles(Integer id);
}
