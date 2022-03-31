package io.ipme.neptunes.Service.dto;

import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Model.Theme;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TrackDTO {

    private Integer id;

    private String trackName;

    private String trackAuthor;

    private Integer trackReleaseYear;

    private String trackURL;

    private List<Theme> themes;

    private Collection<Playlist> playlist;

    public TrackDTO() {
        this.themes = new ArrayList<>();
        this.playlist = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getTrackAuthor() {
        return trackAuthor;
    }

    public Integer getTrackReleaseYear() {
        return trackReleaseYear;
    }

    public String getTrackURL() {
        return trackURL;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public Collection<Playlist> getPlaylist() {
        return playlist;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public void setTrackAuthor(String trackAuthor) {
        this.trackAuthor = trackAuthor;
    }

    public void setTrackReleaseYear(Integer trackReleaseYear) {
        this.trackReleaseYear = trackReleaseYear;
    }

    public void setTrackURL(String trackURL) {
        this.trackURL = trackURL;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public void setPlaylist(Collection<Playlist> playlist) {
        this.playlist = playlist;
    }
}
