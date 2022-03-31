package io.ipme.neptunes.Service.dto;

import io.ipme.neptunes.Model.Playlist;

import java.util.ArrayList;

public class UserDTO {

    private String userName;

    private String avatar;

    private ArrayList<Playlist> playlists;

    public UserDTO() {
        this.playlists = new ArrayList<>();
    }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getAvatar() { return avatar; }

    public void setAvatar(String avatar) { this.avatar = avatar; }

    public ArrayList<Playlist> getPlaylists() { return playlists; }

    public void setPlaylists(ArrayList<Playlist> playlists) { this.playlists = playlists; }

}
