package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.UserGame;
import io.ipme.neptunes.Repository.UserGameRepository;
import io.ipme.neptunes.Service.dto.UserGameDTOForUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserGameService {

    /*
        Initialization
     */
    private UserGameRepository userGameRepository;

    public UserGameService(UserGameRepository userGameRepository) {
        this.userGameRepository = userGameRepository;
    }

    /*
        CRUD methods for users
     */
    public List<UserGameDTOForUser> findByUserId(Integer userId) {
        List<UserGameDTOForUser> userGameDtos = new ArrayList<>();
        for (UserGame userGame : userGameRepository.findByUserGamePK_user_Id(userId)) {
            UserGameDTOForUser userGameDTOForUser = new UserGameDTOForUser();
            BeanUtils.copyProperties(userGame, userGameDTOForUser);
            userGameDTOForUser.setGameId(userGame.getUserGamePK().getGame().getId());
            userGameDtos.add(userGameDTOForUser);
        }
        return userGameDtos;
    }

    public UserGameDTOForUser findByUserIdAndGameId(Integer userId, Integer gameId) {
        UserGameDTOForUser userGameDTO = new UserGameDTOForUser();
        BeanUtils.copyProperties(userGameRepository.findByUserGamePK_user_idAndUserGamePK_game_id(userId, gameId), userGameDTO);
        userGameDTO.setGameId(gameId);
        return userGameDTO;
    }

    /*
        CRUD methods for games
     */

}
