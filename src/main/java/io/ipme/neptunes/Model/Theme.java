package io.ipme.neptunes.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

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

    public Theme(Integer id) {
        this.id = id;
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

    /*
       Override methods
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theme theme = (Theme) o;
        return id.equals(theme.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
