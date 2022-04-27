package io.ipme.neptunes.Service.dto;

import io.ipme.neptunes.Model.Track;

import java.util.List;

public class ThemeDTO {

    private String theme;

    private List<Track> tracks;

    public ThemeDTO(String theme) {
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
