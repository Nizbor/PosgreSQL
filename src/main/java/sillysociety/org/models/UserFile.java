package sillysociety.org.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"User_File\"")
public class UserFile {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"User_id\"", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private File file;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}