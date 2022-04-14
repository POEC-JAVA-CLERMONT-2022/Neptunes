package io.ipme.neptunes;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Model.GameMode;
import io.ipme.neptunes.Model.UserGamePK;
import io.ipme.neptunes.Repository.GameRepository;
import io.ipme.neptunes.Repository.UserGameRepository;
import io.ipme.neptunes.Service.GameService;
import io.ipme.neptunes.Service.UserGameService;
import io.ipme.neptunes.Service.dto.GameDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NeptunesApplicationTests {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;

//    @Test
//    void gameTest(){
//        GameDTO gameDTO1 = new GameDTO();
//        gameDTO1.setGameUrl("neptunes/game1.com");
//        gameDTO1.setGameModeEnumeration(gameDTO1.getGameModeEnumeration();
//        gameDTO1.setPaused(false);
//        gameService.createGame(gameDTO1);
//
//        Assertions.assertFalse(gameDTO1.getPaused(), "Game is paused.");
//        Assertions.assertNotNull(gameDTO1.getGameUrl(), "Game url is not set.");
//        Assertions.assertNotNull(gameDTO1.getGameModeEnumeration(), "Game mode is not set.");
//    }
}
