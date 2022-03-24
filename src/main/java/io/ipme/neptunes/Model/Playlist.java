package io.ipme.neptunes.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Playlist {

    //Constructor
    public Playlist(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "is_random", length = 100)
    private Boolean isRandom;

    @JoinColumn(name = "track_id")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Track> track;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getRandom() {
        return isRandom;
    }

    public void setRandom(Boolean random) {
        isRandom = random;
    }

    public List<Track> getTrack() {
        return track;
    }

    public void setTrack(List<Track> track) {
        this.track = track;
    }

}