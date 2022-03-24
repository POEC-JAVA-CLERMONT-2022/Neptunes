package io.ipme.neptunes.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Track {

    public Track(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "track_Name")
    private String trackName;

    @NotNull
    @Column(name = "track_Author")
    private String trackAuthor;

    @NotNull
    @Column(name = "track_Release_Year")
    private Integer trackReleaseYear;

    @NotNull
    @Column(name = "track_URL")
    private String trackURL;

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

}