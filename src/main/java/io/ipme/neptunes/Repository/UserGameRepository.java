package io.ipme.neptunes.Repository;

import io.ipme.neptunes.Model.UserGame;
import io.ipme.neptunes.Model.UserGamePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserGameRepository extends JpaRepository<UserGame, UserGamePK> {

    List<UserGame> findByUserGamePK_user_Id(Integer id);

    UserGame findByUserGamePK_user_idAndUserGamePK_game_id(Integer uId, Integer gId);
}
