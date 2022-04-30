package io.ipme.neptunes.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Playlist {

    /*attributes*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "is_random")
    private Boolean isRandom;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "playlist")
    private List<Track> tracks;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY)
    private List<Game> games;

    /*constructors*/

    public Playlist() {
    }

    public Playlist(String name, Boolean isRandom) {
        this.name = name;
        this.isRandom = isRandom;
        this.tracks = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    /*getters-setters*/

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}