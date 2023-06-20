package net.palantir.palantirbackend.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "board")
public class Board implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToOne
    private Profile master;

    @ManyToMany
    private List<Player> players;

    public Board() {
    }

    public Board(Long id, String title, String description, Profile master, List<Player> players) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.master = master;
        this.players = players;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Profile getMaster() {
        return master;
    }

    public void setMaster(Profile master) {
        this.master = master;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(id, board.id) && Objects.equals(description, board.description) && Objects.equals(master, board.master) && Objects.equals(players, board.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, master, players);
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", master=" + master +
                ", players=" + players +
                '}';
    }
}
