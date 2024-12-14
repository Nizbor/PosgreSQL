package sillysociety.org.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "\"File\"")
public class File {
    @EmbeddedId
    private FileId id;

    @MapsId("author")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author", nullable = false)
    private sillysociety.org.models.User author;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "edit_date", nullable = false)
    private LocalDate editDate;

    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "path", nullable = false, length = Integer.MAX_VALUE)
    private String path;

    @ColumnDefault("false")
    @Column(name = "diploma", nullable = false)
    private Boolean diploma = false;

    @ColumnDefault("false")
    @Column(name = "final", nullable = false)
    private Boolean finalField = false;

    public FileId getId() {
        return id;
    }

    public void setId(FileId id) {
        this.id = id;
    }

    public sillysociety.org.models.User getAuthor() {
        return author;
    }

    public void setAuthor(sillysociety.org.models.User author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDate editDate) {
        this.editDate = editDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getDiploma() {
        return diploma;
    }

    public void setDiploma(Boolean diploma) {
        this.diploma = diploma;
    }

    public Boolean getFinalField() {
        return finalField;
    }

    public void setFinalField(Boolean finalField) {
        this.finalField = finalField;
    }

}