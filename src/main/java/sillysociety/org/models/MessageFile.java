package sillysociety.org.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Message_File\"")
public class MessageFile {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Message message;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private File file;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}