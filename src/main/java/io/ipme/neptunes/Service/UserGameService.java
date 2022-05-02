package io.ipme.neptunes.Service;

import io.ipme.neptunes.Repository.UserGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGameService {

    private UserGameRepository userGameRepository;

    @Autowired
    public UserGameService(UserGameRepository userGameRepository) {
        this.userGameRepository = userGameRepository;
    }

/*    public ArrayList<UserGameDTO> findGameUsersScoreById(Integer id) {
        ArrayList<UserGameDTO> userGameDtos = new ArrayList<>();
        for (UserGame userGame : userGameRepository.findByUserGamePK_Game_Id(id)) {
            userGameDtos.add(new UserGameDTO(userGame.getUserGamePK(), userGame.getScore()));
        }
        return userGameDtos;
    }*/
}
