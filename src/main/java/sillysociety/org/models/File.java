package sillysociety.org.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Table(name = "\"File\"")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "author", nullable = false)
    private User author;

    @Column(name = "edit_date", nullable = false)
    private OffsetDateTime editDate;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public OffsetDateTime getEditDate() {
        return editDate;
    }

    public void setEditDate(OffsetDateTime editDate) {
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