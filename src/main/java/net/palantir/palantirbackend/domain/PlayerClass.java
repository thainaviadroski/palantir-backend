package net.palantir.palantirbackend.domain;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "player_class")
public class PlayerClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameClass")
    private String nameClass;

    @Column(name = "description")
    private String description;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerClass that = (PlayerClass) o;
        return Objects.equals(id, that.id) && Objects.equals(nameClass, that.nameClass) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameClass, description);
    }

    @Override
    public String toString() {
        return "PlayerClass{" + "id=" + id + ", nameClass='" + nameClass + '\'' + ", description='" + description + '\'' + '}';
    }

}

