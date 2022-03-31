package io.ipme.neptunes.Service.dto;

import io.ipme.neptunes.Model.Track;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDto {

    private Integer id;

    private List<Track> tracks;

    private Boolean isRandom;

    public PlaylistDto() {
        this.tracks = new ArrayList<Track>();
    }

    public Integer getId() {
        return id;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public Boolean getRandom() {
        return isRandom;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void setRandom(Boolean random) {
        isRandom = random;
    }
}
