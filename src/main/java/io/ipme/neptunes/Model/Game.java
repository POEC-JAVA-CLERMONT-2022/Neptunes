package io.ipme.neptunes.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Game {

    /*Attributes*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotBlank
    @Column(name = "game_url")
    private String gameUrl;

    @NotNull
    @Column(name = "is_paused")
    private Boolean isPaused;

    @Column(name = "mode")
    @Enumerated(EnumType.STRING)
    private GameMode gameMode;

    /*Constructors*/

    public Game() {
    }

    public Game(String gameUrl, Boolean isPaused, GameMode gameMode) {
        this.gameUrl = gameUrl;
        this.isPaused = isPaused;
        this.gameMode = gameMode;
    }

    /*getters*/

    public Integer getId() {
        return id;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public Boolean getPaused() {
        return isPaused;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    /*setter*/

    public void setGameMode(GameMode gameMode) { this.gameMode = gameMode; }

    public void setGameUrl(String gameUrl) { this.gameUrl = gameUrl; }

    public void setPaused(Boolean paused) { isPaused = paused; }

}