package io.ipme.neptunes.Model;

public class Game {
    private String gameUrl;
    private boolean isPaused = false;

    /**
     * constructor
     */
    public Game(String gameUrl, boolean isPaused){
        this.gameUrl = gameUrl;
        this.isPaused = isPaused;
    }

    /**
     *getters/setters
     */
    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }
}
