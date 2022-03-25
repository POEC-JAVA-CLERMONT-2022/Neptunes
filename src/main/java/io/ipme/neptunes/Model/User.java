package io.ipme.neptunes.Model;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.Type;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {

    /*
     * 	Attributes
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "user_name", length = 255)
    private String userName;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "is_Premium", nullable = false)
    private Boolean isPremium;

    /*
     * 	Getters
     */
    public User() {
    }

    public UUID getId() {
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

    /*
    *   Setters
    */
    public void setId(UUID id) {
        this.id = id;
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