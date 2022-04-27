package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.UserGame;
import io.ipme.neptunes.Repository.UserGameRepository;
import io.ipme.neptunes.Service.dto.UserGameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserGameService {

    private UserGameRepository userGameRepository;

    @Autowired
    public UserGameService(UserGameRepository userGameRepository) {
        this.userGameRepository = userGameRepository;
    }

    public ArrayList<UserGameDTO> findGameUsersScoreById(Integer id) {
        ArrayList<UserGameDTO> userGameDtos = new ArrayList<>();
        for (UserGame userGame : userGameRepository.findByUserGamePK_Game_Id(id)) {
            userGameDtos.add(new UserGameDTO(userGame.getUserGamePK(), userGame.getScore()));
        }
        return userGameDtos;
    }
}
