package io.ipme.neptunes.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "theme", length = 100)
    private String theme;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "themes")
    private List<Track> tracks;

    public Theme() {

    }

    public Integer getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

}
