package sillysociety.org.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"User_Chat\"")
public class UserChat {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"User_id\"", nullable = false)
    private sillysociety.org.filework.User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"Chat_id\"", nullable = false)
    private sillysociety.org.filework.Chat chat;

    public sillysociety.org.filework.User getUser() {
        return user;
    }

    public void setUser(sillysociety.org.filework.User user) {
        this.user = user;
    }

    public sillysociety.org.filework.Chat getChat() {
        return chat;
    }

    public void setChat(sillysociety.org.filework.Chat chat) {
        this.chat = chat;
    }

}