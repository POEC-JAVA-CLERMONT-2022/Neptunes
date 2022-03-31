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
}
