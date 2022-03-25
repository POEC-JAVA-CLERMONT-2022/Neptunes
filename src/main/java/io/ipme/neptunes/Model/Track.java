package io.ipme.neptunes.Model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Track {

    public Track(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

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

    public UUID getId() {
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