package io.ipme.neptunes.Service.dto;

import io.ipme.neptunes.Model.Track;

import java.util.List;

public class PlaylistDTO {

    private String name;

    private List<Track> tracks;

    private Boolean isRandom;

    public String getName() { return name; }

    public List<Track> getTracks() {
        return tracks;
    }

    public Boolean getRandom() {
        return isRandom;
    }

    public void setName(String name) { this.name = name; }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void setRandom(Boolean random) {
        isRandom = random;
    }
}
