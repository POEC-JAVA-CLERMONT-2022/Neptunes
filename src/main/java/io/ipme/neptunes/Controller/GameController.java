package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Service.GameService;
import io.ipme.neptunes.Service.UserGameService;
import io.ipme.neptunes.Service.dto.GameDTO;
import io.ipme.neptunes.Service.dto.UpdateGameDTO;
import io.ipme.neptunes.Service.dto.UserGameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("games")
    public class GameController {

        @Autowired
        private GameService gameService;

        @Autowired
        private UserGameService userGameService;

        @GetMapping
        public ResponseEntity<List<GameDTO>> getAll(){

            try {
                return ResponseEntity.ok().body(gameService.findAll());
            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
        }

        @GetMapping("{id}")
        public ResponseEntity<GameDTO> getOne(@PathVariable Integer id) {

            try {
                if (id != null) {
                    return ResponseEntity.ok().body(gameService.findOne(id));
                }
                return ResponseEntity.badRequest().build();
            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
        }


        @PostMapping
        public ResponseEntity<Game> createPlaylist(@RequestBody Game game) {

            try {
                if (game != null){
                    gameService.createGame(new GameDTO());
                }
                return ResponseEntity.status(201).build();
            } catch (Exception e) {
                return ResponseEntity.status(400).build();
            }
        }

        @DeleteMapping("{id}")
        public ResponseEntity<Playlist> deleteGame(@RequestBody @PathVariable Integer id) {

            try {
                if (id != null){
                    gameService.deleteGame(id);
                }
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                return ResponseEntity.status(400).build();
            }
        }

        @GetMapping("{id}/users/scores")
        public ArrayList<UserGameDTO> getUsersAndScores(@PathVariable Integer id) {
            return userGameService.findGameUsersScoreById(id);
        }

        @PutMapping("{id}")
        public ResponseEntity<String> updateGameMode(@RequestBody String gameModeName, @PathVariable Integer id) {
            try {
                if (gameModeName != null && id != null) {
                    gameService.setGameMode(id, gameModeName);
                    return ResponseEntity.ok().build();
                }
                return ResponseEntity.badRequest().build();
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PatchMapping("{id}")
        public ResponseEntity<String> updateGame(@PathVariable Integer id, @RequestBody UpdateGameDTO updateGameDTO) {
            try {
                if (id != null && updateGameDTO != null) {
                    gameService.updateGame(id, updateGameDTO);
                    return ResponseEntity.ok().build();
                }
                return ResponseEntity.badRequest().build();
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

}
