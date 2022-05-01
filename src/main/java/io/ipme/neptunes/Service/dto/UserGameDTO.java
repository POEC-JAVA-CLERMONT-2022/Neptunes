package io.ipme.neptunes.Service.dto;

import io.ipme.neptunes.Model.Game;

public class UserGameDTO {

    private Game game;

    private Integer score;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
