package io.ipme.neptunes.Model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Playlist {

    //Constructor
    public Playlist(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "is_random", length = 100)
    private Boolean isRandom;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "playlist")
    private List<Track> tracks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getRandom() {
        return isRandom;
    }

    public void setRandom(Boolean random) {
        isRandom = random;
    }

    public List<Track> getTrack() {
        return tracks;
    }

    public void setTrack(List<Track> track) {
        this.tracks = track;
    }

}