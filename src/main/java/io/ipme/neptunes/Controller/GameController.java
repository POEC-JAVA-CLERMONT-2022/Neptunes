package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Model.Track;
import io.ipme.neptunes.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    public class GameController {

        @Autowired
        private GameService gameService;

        @GetMapping("/games")
        public List<Game> getAll(){
            return gameService.findAll();
        }

        @GetMapping("/games/{id}")
        public Optional<Game> getOne(@PathVariable Integer id){
            return gameService.findOne(id);
        }

        @PostMapping("/games")
        public void createGame(@RequestBody Game game) {
            gameService.createGame(game);
        }

        @DeleteMapping("/games/{id}")
        public void createGame(@RequestBody @PathVariable Integer id) {
            gameService.deleteGame(id);
        }
}