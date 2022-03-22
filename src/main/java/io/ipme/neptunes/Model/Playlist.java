package io.ipme.neptunes.Model;

import java.util.ArrayList;

public class Playlist {

    //Attributes
    private String playlistName;
    private Boolean isRandom;
    private ArrayList<Track> tracks;

    //Constructor
    public Playlist(String playlistName,ArrayList<Track> tracks, Boolean isRandom){
        this.playlistName = playlistName;
        this.isRandom = isRandom;
        this.tracks = tracks;
    }

    //Getters
    public String getPlaylistName() {
        return playlistName;
    }

    public Boolean getRandom() {
        return isRandom;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistName='" + playlistName + '\'' +
                ", isRandom=" + isRandom +"\n"+
                ", tracks=" + tracks +"\n"+
                '}';
    }

}