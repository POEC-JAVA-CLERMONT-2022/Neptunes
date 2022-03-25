package io.ipme.neptunes.Model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Game {

    /**
     * constructor
     */
    public Game() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "game_url", length = 100)
    private String gameUrl;

    @Column(name = "is_paused")
    private Boolean isPaused;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Score> score;

    @OneToOne(fetch = FetchType.LAZY)
    private Playlist playlist;

    /**
     *getters/setters
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }

    public Boolean getPaused() {
        return isPaused;
    }

    public void setPaused(Boolean paused) {
        isPaused = paused;
    }

    public List<Score> getScore() {
        return score;
    }

    public void setScore(List<Score> score) {
        this.score = score;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

}