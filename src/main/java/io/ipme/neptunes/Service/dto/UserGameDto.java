package io.ipme.neptunes.Service.dto;

import io.ipme.neptunes.Model.UserGamePK;

public class UserGameDto {
    private String user;

    private Integer score;

    public UserGameDto(UserGamePK userGamePK, Integer score) {
        this.user = userGamePK.getUser().getUserName();
        this.score = score;
    }

    public String getUser() {
        return user;
    }

    public Integer getScore() {
        return score;
    }
}
