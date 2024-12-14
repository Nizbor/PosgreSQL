package sillysociety.org.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "\"Message\"")
public class Message {
    @EmbeddedId
    private MessageId id;

    @MapsId("chat")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chat", nullable = false)
    private Chat chat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"from\"")
    private sillysociety.org.models.User from;

    @Column(name = "\"time\"", nullable = false)
    private LocalDate time;

    @Column(name = "text_message", length = Integer.MAX_VALUE)
    private String textMessage;

    public MessageId getId() {
        return id;
    }

    public void setId(MessageId id) {
        this.id = id;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public sillysociety.org.models.User getFrom() {
        return from;
    }

    public void setFrom(sillysociety.org.models.User from) {
        this.from = from;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

}