package sillysociety.org.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class MessageId implements java.io.Serializable {
    private static final long serialVersionUID = 798728266521571614L;
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "chat", nullable = false)
    private Integer chat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChat() {
        return chat;
    }

    public void setChat(Integer chat) {
        this.chat = chat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MessageId entity = (MessageId) o;
        return Objects.equals(this.chat, entity.chat) &&
                Objects.equals(this.id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chat, id);
    }

}