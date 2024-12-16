package sillysociety.org.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Message_File\"")
public class MessageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Message_File_id_gen")
    @SequenceGenerator(name = "Message_File_id_gen", sequenceName = "\"Message_File_id_seq\"", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"Message_id\"", nullable = false)
    private Message message;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"File_id\"", nullable = false)
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