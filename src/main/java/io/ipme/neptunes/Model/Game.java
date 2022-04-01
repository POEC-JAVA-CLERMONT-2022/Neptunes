package io.ipme.neptunes.Model;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Game {

    /**
     * constructor
     */
    public Game() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "game_url", length = 100)
    private String gameUrl;

    @NotNull
    @Column(name = "is_paused")
    private Boolean isPaused;

    @NotNull
    @Enumerated(EnumType.STRING)
    private GameMode mode;

    /**
     *getters
     */

    public Integer getId() {
        return id;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public Boolean getPaused() {
        return isPaused;
    }

    public GameMode getMode() {
        return mode;
    }

}