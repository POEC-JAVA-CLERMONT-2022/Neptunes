package io.ipme.neptunes.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "user_name")
    private String userName;

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;

    /*Set un avatar par défaut si l'utilisateur n'en choisit pas.*/
    @Column(name = "avatar")
    private String avatar;

    @NotNull
    @Column(name = "is_Premium", nullable = false)
    private Boolean isPremium;

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    @OneToMany(fetch = FetchType.LAZY)
    private List<Playlist> playlists;

    public User() {

    }

    public User(String name) { this.userName = name; }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAvatar() {
        return avatar;
    }

    public Boolean getPremium() {
        return isPremium;
    }
}