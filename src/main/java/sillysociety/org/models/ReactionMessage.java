package sillysociety.org.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Reaction_Message\"")
public class ReactionMessage {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"Reaction_id\"", nullable = false)
    private Reaction reaction;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Message message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}