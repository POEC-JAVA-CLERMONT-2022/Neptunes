package io.ipme.neptunes.Service.dto;

public class UserDTO {

    private Integer id;

    private String userName;

    private String avatar;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) { this.userName = userName; }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) { this.avatar = avatar; }

}
