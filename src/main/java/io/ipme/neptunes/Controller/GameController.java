package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Service.GameService;
import io.ipme.neptunes.Service.UserGameService;
import io.ipme.neptunes.Service.dto.GameDTO;
import io.ipme.neptunes.Service.dto.GameCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.PlaylistDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("games")
public class GameController {

    /*
        Initialization
     */
    private GameService gameService;

    public GameController(GameService gameService, UserGameService userGameService) {
        this.gameService = gameService;
    }

    /*
        CRUD Mapping
     */
    @GetMapping
    public ResponseEntity<List<GameDTO>> getAll() {
        try {
            return ResponseEntity.ok(gameService.findAll());
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
    public ResponseEntity<?> createGame(@Valid @RequestBody GameCreateUpdateDTO gameDTOCreateDTO) {

        try {
            if (gameDTOCreateDTO != null) {
                return ResponseEntity.ok(gameService.createGame(gameDTOCreateDTO));
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

    @PatchMapping("{id}")
    public ResponseEntity<?> updateGame(@PathVariable Integer id, @Valid @RequestBody GameCreateUpdateDTO gameUpdateDTO) {
        try {
            if (id != null && gameUpdateDTO != null) {
                return ResponseEntity.ok(gameService.updateGame(id, gameUpdateDTO));
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

    /*
        Playlist Mapping
     */
    @GetMapping("{id}/playlists")
    public ResponseEntity<PlaylistDTO> getPlaylist(@PathVariable Integer id) {
        try {
            if (id != null) {
                /*return de la méthode*/
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
