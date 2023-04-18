package net.palantir.palantirbackend.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "race")
public class Race implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "race_name")
    private String raceName;

    @Column(name = "description")
    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
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
        Race race = (Race) o;
        return Objects.equals(id, race.id) && Objects.equals(raceName, race.raceName) && Objects.equals(description, race.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, raceName, description);
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", raceName='" + raceName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
