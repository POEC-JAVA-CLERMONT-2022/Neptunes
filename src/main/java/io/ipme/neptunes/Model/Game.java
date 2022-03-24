package io.ipme.neptunes.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Game {

    /**
     * constructor
     */
    public Game() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "game_url", length = 100)
    private String gameUrl;

    @Column(name = "is_paused")
    private Boolean isPaused;

    /**
     *getters/setters
     */

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getPaused() {
        return isPaused;
    }

    public void setPaused(Boolean paused) {
        isPaused = paused;
    }

}