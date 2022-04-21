package io.ipme.neptunes.Service.dto;

import io.ipme.neptunes.Model.GameMode;
import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Model.User;

import java.util.ArrayList;

public class UpdateGameDTO {

    private String gameUrl;

    private Boolean isPaused;

    /*
    private GameMode gameMode;

    private ArrayList<User> users;

    private Playlist playlist;
*/

    public UpdateGameDTO() {
    }

    public String getGameUrl() { return gameUrl; }

    public void setGameUrl(String gameUrl) { this.gameUrl = gameUrl; }

    public Boolean getPaused() { return isPaused; }

    public void setPaused(Boolean paused) { isPaused = paused; }

    /*
    public GameMode getGameMode() { return gameMode; }

    public void setGameMode(GameMode gameMode) { this.gameMode = gameMode; }

    public ArrayList<User> getUsers() { return users; }

    public void setUsers(ArrayList<User> users) { this.users = users; }

    public Playlist getPlaylist() { return playlist; }

    public void setPlaylist(Playlist playlist) { this.playlist = playlist; }
*/
}
