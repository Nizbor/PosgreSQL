package sillysociety.org.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "\"Message\"")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"from\"")
    private User from;

    @Column(name = "chat", nullable = false)
    private Integer chat;

    @Column(name = "\"time\"", nullable = false)
    private LocalDate time;

    @Column(name = "text_message", length = Integer.MAX_VALUE)
    private String textMessage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public Integer getChat() {
        return chat;
    }

    public void setChat(Integer chat) {
        this.chat = chat;
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