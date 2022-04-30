package io.ipme.neptunes.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Theme {

    /*
        Attributes
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotBlank
    @Column(name = "theme")
    private String theme;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "themes")
    private List<Track> tracks;

    /*
        Constructors
     */
    public Theme() {
    }

    public Theme(String theme) {
        this.theme = theme;
    }

    /*
        Getters - Setters
     */
    public Integer getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<Track> getTracks() {
        return tracks;
    }

}
