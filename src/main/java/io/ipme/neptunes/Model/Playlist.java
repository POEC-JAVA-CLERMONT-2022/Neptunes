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
    private Integer id;

    @Column(name = "is_random", length = 100)
    private Boolean isRandom;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "playlist")
    private List<Track> tracks;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Game> games;

    /**
     *getters/setters
     */

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

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", isRandom=" + isRandom +
                ", tracks=" + tracks +
                ", games=" + games +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (isRandom != null ? isRandom.hashCode() : 0);
        result = 31 * result + (tracks != null ? tracks.hashCode() : 0);
        result = 31 * result + (games != null ? games.hashCode() : 0);
        return result;
    }
}