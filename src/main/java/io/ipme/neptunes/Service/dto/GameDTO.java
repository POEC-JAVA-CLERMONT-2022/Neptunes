package io.ipme.neptunes.Service.dto;

import io.ipme.neptunes.Model.GameMode;

public class GameDTO {

    private Integer id;
    private String gameUrl;
    private Boolean isPaused;
    private GameMode gameMode;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }

    public void setPaused(Boolean paused) {
        isPaused = paused;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }
}
