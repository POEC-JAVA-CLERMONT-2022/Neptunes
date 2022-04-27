package io.ipme.neptunes.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Playlist {

    public Playlist() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "is_random", length = 100)
    private Boolean isRandom;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "playlist")
    private List<Track> tracks;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY)
    private List<Game> games;

    /*getters-setters*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setGames(List<Game> games) {
        this.games = games;
    }

}