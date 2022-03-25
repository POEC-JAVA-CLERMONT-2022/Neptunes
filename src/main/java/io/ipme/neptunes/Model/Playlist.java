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

    @OneToMany(fetch = FetchType.LAZY)
    private List<Game> games;

    /**
     *getters/setters
     */

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

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

}