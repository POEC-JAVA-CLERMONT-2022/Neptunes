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

    // Test utilisation Mock
/*
    @Test
    public void testCreationLegume()
    {
        when(mockedLegumeRepo.save(Mockito.any(Legume.class))).thenReturn(new Legume(null, null, 0, 0, null, false, false, null));
        Legume testLegume = legumeService.create(null, 0, 0, null, false, false, null);
        // test null
        assertNotNull(testLegume);
        // test id null comme dans le test
        Assertions.assertEquals(testLegume.getIdLegume(), null);
        // test objet non null
        assertThat(testLegume).isNotNull();
        // test id null comme dans le test
        assertThat(testLegume.getIdLegume()).isNull();
        // test si les références sont égales
        assertThat(testLegume).isSameAs(new Legume(null, null, 0, 0, null, false, false, null));
        // test si tous les champs sont ok par rapport au premier argument
        assertThat(testLegume).usingRecursiveComparison().isEqualTo(new Legume (null, null, 0, 0, null, false, false, null));

        // Verifie une fois l'utilisation du repo mocked avec un legume mocked
        Mockito.verify(mockedLegumeRepo, times(1)).save(Mockito.any(Legume.class));
    }
*/
}
