package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.UserGame;
import io.ipme.neptunes.Repository.UserGameRepository;
import io.ipme.neptunes.Service.dto.UserGameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserGameService {

    @Autowired
    private UserGameRepository userGameRepository;

    public ArrayList<UserGameDto> findGameUsersScoreById(Integer id) {
        ArrayList<UserGameDto> userGameDtos = new ArrayList<>();
        for(UserGame userGame : userGameRepository.findByUserGamePK_Game_Id(id)) {
            userGameDtos.add(new UserGameDto(userGame.getUserGamePK(), userGame.getScore()));
        }
        return userGameDtos;
    }
}
