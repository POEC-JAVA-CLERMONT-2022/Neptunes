package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Service.GameService;
import io.ipme.neptunes.Service.UserGameService;
import io.ipme.neptunes.Service.dto.UserGameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
    public class GameController {

        @Autowired
        private GameService gameService;

        @Autowired
        private UserGameService userGameService;

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

        @GetMapping("/games/{id}/users/scores")
        public ArrayList<UserGameDto> getUsersAndScores(@PathVariable Integer id) {
            return userGameService.findGameUsersScoreById(id);
        }
}
