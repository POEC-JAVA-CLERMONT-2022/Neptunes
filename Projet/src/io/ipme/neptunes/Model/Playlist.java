package io.ipme.neptunes.Model;

public class Playlist {

    //Attributes
    private String playlistName;
    private Integer trackOrder;
    private Boolean isRandom;

    //Constructor
    public Playlist(String playlistName, Integer trackOrder, Boolean isRandom){
        this.playlistName = playlistName;
        this.trackOrder = trackOrder;
        this.isRandom = isRandom;
    }

    //Getters
    public String getPlaylistName() {
        return playlistName;
    }

    public Integer getTrackOrder() {
        return trackOrder;
    }

    public Boolean getRandom() {
        return isRandom;
    }
}
