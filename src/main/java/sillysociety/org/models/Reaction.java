package sillysociety.org.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Reaction\"")
public class Reaction {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "field", nullable = false, length = Integer.MAX_VALUE)
    private String field;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

}