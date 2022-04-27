package io.ipme.neptunes.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", tracks=" + tracks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theme theme1 = (Theme) o;
        return id.equals(theme1.id) && theme.equals(theme1.theme) && tracks.equals(theme1.tracks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, theme, tracks);
    }
}
