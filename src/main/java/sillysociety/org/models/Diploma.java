package sillysociety.org.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Diploma\"")
public class Diploma {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "mark")
    private Integer mark;

    @ManyToOne(fetch = FetchType.LAZY)
    private sillysociety.org.filework.File file;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public sillysociety.org.filework.File getFile() {
        return file;
    }

    public void setFile(sillysociety.org.filework.File file) {
        this.file = file;
    }

}