package io.ipme.neptunes.Model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Entity
public class Track {

    public Track() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "track_Name")
    private String trackName;

    @NotBlank
    @Column(name = "track_Author")
    private String trackAuthor;

    @NotNull
    @Min(1900)
    @Max(2050)
    @Column(name = "track_Release_Year")
    private Integer trackReleaseYear;

    @NotBlank
    @Column(name = "track_URL")
    private String trackURL;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Theme> themes;

    @ManyToMany
    private Collection<Playlist> playlist;

    /*getters-setters*/

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

}