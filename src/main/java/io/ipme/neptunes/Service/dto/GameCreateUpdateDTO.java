package io.ipme.neptunes.Service.dto;

import io.ipme.neptunes.Model.GameMode;

public class GameCreateUpdateDTO {

    private String gameUrl;
    private Boolean isPaused;
    private GameMode gameMode;

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }

    public Boolean getPaused() {
        return isPaused;
    }

    public void setPaused(Boolean paused) {
        isPaused = paused;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }
}
