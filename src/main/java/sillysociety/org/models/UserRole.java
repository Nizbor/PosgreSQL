package sillysociety.org.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"User_Role\"")
public class UserRole {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"User_id\"", nullable = false)
    private sillysociety.org.filework.User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"Role_id\"", nullable = false)
    private sillysociety.org.filework.Role role;

    public sillysociety.org.filework.User getUser() {
        return user;
    }

    public void setUser(sillysociety.org.filework.User user) {
        this.user = user;
    }

    public sillysociety.org.filework.Role getRole() {
        return role;
    }

    public void setRole(sillysociety.org.filework.Role role) {
        this.role = role;
    }

}