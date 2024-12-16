package sillysociety.org.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Diploma\"")
public class Diploma {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Diploma_id_gen")
    @SequenceGenerator(name = "Diploma_id_gen", sequenceName = "\"Diploma_id_seq\"", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "mark")
    private Integer mark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "files")
    private File files;

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

    public File getFiles() {
        return files;
    }

    public void setFiles(File files) {
        this.files = files;
    }

}