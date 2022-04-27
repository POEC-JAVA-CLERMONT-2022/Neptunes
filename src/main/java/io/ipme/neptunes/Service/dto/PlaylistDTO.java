package io.ipme.neptunes.Service.dto;

import io.ipme.neptunes.Model.Track;

import java.util.ArrayList;
import java.util.List;

public class PlaylistDTO {

    private List<Track> tracks;

    private Boolean isRandom;

    public PlaylistDTO() {
        this.tracks = new ArrayList<Track>();
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public Boolean getRandom() {
        return isRandom;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void setRandom(Boolean random) {
        isRandom = random;
    }
}
