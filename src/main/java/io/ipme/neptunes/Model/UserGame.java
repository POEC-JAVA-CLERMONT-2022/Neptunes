package io.ipme.neptunes.Model;

import javax.persistence.*;

@Entity
@AssociationOverrides(
        {
                @AssociationOverride(name = "usergame.game", joinColumns = @JoinColumn(name = "game_id")),
                @AssociationOverride(name = "usergame.user", joinColumns = @JoinColumn(name = "user_id")),
        }
)
public class UserGame {

    @EmbeddedId
    private UserGamePK userGamePK;

    @Column(name = "score")
    private Integer score;

    protected UserGame() {

    }

    public UserGamePK getUserGamePK() {
        return userGamePK;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
