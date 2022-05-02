package io.ipme.neptunes.Repository;

import io.ipme.neptunes.Model.UserGame;
import io.ipme.neptunes.Model.UserGamePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserGameRepository extends JpaRepository<UserGame, UserGamePK> {

    List<UserGame> findByUserGamePK_user_Id(Integer id);

    /*@Query("select u from UserGame u where user_id = :uId and game_id = :gId")
    UserGame findByUserGamePK(@Param("uId") Integer uId, @Param("gId") Integer gId);*/

    UserGame findByUserGamePK_user_idAndUserGamePK_game_id(Integer uId, Integer gId);
}
