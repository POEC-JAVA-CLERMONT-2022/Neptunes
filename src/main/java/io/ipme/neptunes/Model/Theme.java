package io.ipme.neptunes.Model;

import jdk.jfr.Enabled;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Theme {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "theme", length = 100)
    private String theme;

    public Theme() {

    }

    public UUID getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

}
