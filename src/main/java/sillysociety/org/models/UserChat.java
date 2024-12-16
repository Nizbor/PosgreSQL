package sillysociety.org.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"User_Chat\"")
public class UserChat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_Chat_id_gen")
    @SequenceGenerator(name = "User_Chat_id_gen", sequenceName = "\"User_Chat_id_seq\"", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"User_id\"", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"Chat_id\"", nullable = false)
    private Chat chat;

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

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

}