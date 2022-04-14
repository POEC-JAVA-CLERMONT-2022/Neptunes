package io.ipme.neptunes.Service.dto;

import io.ipme.neptunes.Model.GameMode;

import java.util.Enumeration;

public class GameDTO {

    private Integer id;
    private String gameUrl;
    private Boolean isPaused;
    private Enumeration<GameMode> gameModeEnumeration;

    public GameDTO(Integer id, String gameUrl, Boolean isPaused, Enumeration<GameMode> gameModeEnumeration){
        this.id = id;
        this.gameUrl = gameUrl;
        this.isPaused = isPaused;
        this.gameModeEnumeration = gameModeEnumeration;
    }

    public GameDTO(String gameUrl){
        this.gameUrl = gameUrl;
    }

    public GameDTO(){

    }

    public Integer getId() { return id; }

    public String getGameUrl() {
        return gameUrl;
    }

    public Boolean getPaused() {
        return isPaused;
    }

    public Enumeration<GameMode> getGameModeEnumeration() {
        return gameModeEnumeration;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }

    public void setPaused(Boolean paused) {
        isPaused = paused;
    }

    public void setGameModeEnumeration(Enumeration<GameMode> gameModeEnumeration) {
        this.gameModeEnumeration = gameModeEnumeration;
    }
}
