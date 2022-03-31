package io.ipme.neptunes;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Repository.GameRepository;
import io.ipme.neptunes.Service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

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
    }
}
