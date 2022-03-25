package io.ipme.neptunes.Model;

import jdk.jfr.Enabled;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "theme", length = 100)
    private String theme;

    public Theme() {

    }

    public Long getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

}
