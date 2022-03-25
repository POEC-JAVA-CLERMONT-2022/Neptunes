package io.ipme.neptunes.Model;

import jdk.jfr.Enabled;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Enabled
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
