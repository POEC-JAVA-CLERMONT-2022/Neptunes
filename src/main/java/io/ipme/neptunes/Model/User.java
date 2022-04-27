package io.ipme.neptunes.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
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
    @Column(name = "is_Premium")
    private Boolean isPremium;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Playlist> playlists;

    public User() {
    }

    public User(String userName, String email, String password, String avatar, Boolean isPremium) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.isPremium = isPremium;
    }

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

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }
}