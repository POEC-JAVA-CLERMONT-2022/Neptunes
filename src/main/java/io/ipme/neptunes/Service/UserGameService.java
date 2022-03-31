package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.UserGame;
import io.ipme.neptunes.Model.UserGamePK;
import io.ipme.neptunes.Repository.UserGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserGameService {

    @Autowired
    private UserGameRepository userGameRepository;

    public List<UserGame> findGameUsersScoreById(Integer id) { return userGameRepository.findByUserGamePK_Game_Id(id); }
}
