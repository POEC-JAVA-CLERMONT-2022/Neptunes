package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    public class GameController {

        @Autowired
        private GameService gameService;

        @GetMapping("/games")
        public List<Game> getAll(){
            return gameService.findAll();
        }
}
