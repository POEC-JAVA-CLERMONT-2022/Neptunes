package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Model.User;
import io.ipme.neptunes.Model.UserGame;
import io.ipme.neptunes.Model.UserGamePK;
import io.ipme.neptunes.Repository.UserGameRepository;
import io.ipme.neptunes.Service.dto.UserGameDTOForGame;
import io.ipme.neptunes.Service.dto.UserGameDTOForUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserGameService {

    // region Initialization
    private final UserGameRepository userGameRepository;

    public UserGameService(UserGameRepository userGameRepository) {
        this.userGameRepository = userGameRepository;
    }
    // endregion

    // region CRUD methods for User
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
    // endregion

    // region CRUD methods for Game
    public List<UserGameDTOForGame> findByGameId(Integer gameId) {
        List<UserGameDTOForGame> userGameDtos = new ArrayList<>();
        for (UserGame userGame : userGameRepository.findByUserGamePK_game_Id(gameId)) {
            UserGameDTOForGame userGameDTOForGame = new UserGameDTOForGame();
            BeanUtils.copyProperties(userGame, userGameDTOForGame);
            userGameDTOForGame.setUserId(userGame.getUserGamePK().getUser().getId());
            userGameDTOForGame.setUserName(userGame.getUserGamePK().getUser().getUserName());
            userGameDtos.add(userGameDTOForGame);
        }
        return userGameDtos;
    }

    public UserGameDTOForGame findHighScore(Integer gameId) {
        UserGameDTOForGame userGameDTO = new UserGameDTOForGame();
        List<UserGame> userGames = userGameRepository.findByUserGamePK_game_idOrderByScoreDesc(gameId);
        BeanUtils.copyProperties(userGames.get(0), userGameDTO);
        userGameDTO.setUserId(userGames.get(0).getUserGamePK().getUser().getId());
        userGameDTO.setUserName(userGames.get(0).getUserGamePK().getUser().getUserName());
        return userGameDTO;
    }

    public void addUserToGame(Integer gameId, Integer userId) {
        /*Add user to the game*/
        UserGamePK userGamePK = new UserGamePK(new User(userId), new Game(gameId));
        UserGame userGame = new UserGame(userGamePK, 0);
        userGameRepository.save(userGame);
    }

    public void removeUserFromGame(Integer gameId, Integer userId) {
        userGameRepository.deleteById(new UserGamePK(new User(userId), new Game(gameId)));
    }

    public void addPoints(Integer gameId, Integer userId, Integer points) {
        UserGame userGame = userGameRepository.findByUserGamePK_user_idAndUserGamePK_game_id(userId, gameId);
        userGame.setScore(userGame.getScore() + points);
        userGameRepository.save(userGame);
    }
    // endregion

}
