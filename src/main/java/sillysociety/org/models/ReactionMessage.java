package sillysociety.org.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Reaction_Message\"")
public class ReactionMessage {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"Reaction_id\"", nullable = false)
    private sillysociety.org.filework.Reaction reaction;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private sillysociety.org.filework.Message message;

    public sillysociety.org.filework.Reaction getReaction() {
        return reaction;
    }

    public void setReaction(sillysociety.org.filework.Reaction reaction) {
        this.reaction = reaction;
    }

    public sillysociety.org.filework.Message getMessage() {
        return message;
    }

    public void setMessage(sillysociety.org.filework.Message message) {
        this.message = message;
    }

}