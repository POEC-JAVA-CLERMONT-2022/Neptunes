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

    @Autowired
    public GameController(GameService gameService, UserGameService userGameService) {
        this.gameService = gameService;
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

    @PutMapping("{id}")
    public ResponseEntity<?> updateGameMode(@RequestBody String gameModeName, @PathVariable Integer id) {
        try {
            if (gameModeName != null && id != null) {
                return ResponseEntity.ok(gameService.setGameMode(id, gameModeName));
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> updateGame(@PathVariable Integer id, @RequestBody GameDTO gameDTO) {
        try {
            if (id != null && gameDTO != null) {
                return ResponseEntity.ok(gameService.updateGame(id, gameDTO));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
