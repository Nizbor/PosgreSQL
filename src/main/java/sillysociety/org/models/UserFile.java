package sillysociety.org.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"User_File\"")
public class UserFile {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"User_id\"", nullable = false)
    private sillysociety.org.filework.User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private sillysociety.org.filework.File file;

    public sillysociety.org.filework.User getUser() {
        return user;
    }

    public void setUser(sillysociety.org.filework.User user) {
        this.user = user;
    }

    public sillysociety.org.filework.File getFile() {
        return file;
    }

    public void setFile(sillysociety.org.filework.File file) {
        this.file = file;
    }

}