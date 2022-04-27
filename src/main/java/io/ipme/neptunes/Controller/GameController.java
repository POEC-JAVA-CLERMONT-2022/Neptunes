package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Service.GameService;
import io.ipme.neptunes.Service.UserGameService;
import io.ipme.neptunes.Service.dto.GameDTO;
import io.ipme.neptunes.Service.dto.UpdateGameDTO;
import io.ipme.neptunes.Service.dto.UserGameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("games")
public class GameController {

    private GameService gameService;

    private UserGameService userGameService;

    @Autowired
    public GameController(GameService gameService, UserGameService userGameService) {
        this.gameService = gameService;
        this.userGameService = userGameService;
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> getAll() {

        try {
            return ResponseEntity.ok().body(gameService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<GameDTO> getOne(@PathVariable Integer id) {

        try {
            if (id != null) {
                return ResponseEntity.ok(gameService.findOne(id));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping
    public ResponseEntity createGame(@RequestBody GameDTO gameDTO) {

        try {
            if (gameDTO != null) {
                gameService.createGame(gameDTO);
                return ResponseEntity.ok(HttpStatus.CREATED);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteGame(@PathVariable Integer id) {

        try {
            if (id != null) {
                gameService.deleteGame(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
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
