package sillysociety.org.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Message_File\"")
public class MessageFile {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private sillysociety.org.filework.Message message;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private sillysociety.org.filework.File file;

    public sillysociety.org.filework.Message getMessage() {
        return message;
    }

    public void setMessage(sillysociety.org.filework.Message message) {
        this.message = message;
    }

    public sillysociety.org.filework.File getFile() {
        return file;
    }

    public void setFile(sillysociety.org.filework.File file) {
        this.file = file;
    }

}