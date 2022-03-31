package io.ipme.neptunes;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Model.GameMode;
import io.ipme.neptunes.Model.UserGamePK;
import io.ipme.neptunes.Repository.GameRepository;
import io.ipme.neptunes.Repository.UserGameRepository;
import io.ipme.neptunes.Service.GameService;
import io.ipme.neptunes.Service.UserGameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NeptunesApplicationTests {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;

    @Test
    void gameTest(){
        //création d'une game test.
        Game game1 = new Game();
        game1.setGameUrl("neptunes/game1.com");
        game1.setMode(GameMode.Normal);
        game1.setPaused(false);
        gameService.createGame(game1);
        gameRepository.saveAndFlush(game1);

        Assertions.assertFalse(game1.getPaused(), "Game is paused.");
        Assertions.assertNotNull(game1.getGameUrl(), "Game url is not set.");
        Assertions.assertNotNull(game1.getMode(), "Game mode is not set.");
    }
}
