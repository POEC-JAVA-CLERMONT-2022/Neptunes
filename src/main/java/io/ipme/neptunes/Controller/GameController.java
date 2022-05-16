package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Service.GameService;
import io.ipme.neptunes.Service.UserGameService;
import io.ipme.neptunes.Service.dto.GameDTO;
import io.ipme.neptunes.Service.dto.GameCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.PlaylistDTO;
import io.ipme.neptunes.Service.dto.UserGameDTOForGame;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("games")
public class GameController {

    // region Initialization
    private final GameService gameService;

    public GameController(GameService gameService, UserGameService userGameService) {
        this.gameService = gameService;
    }
    // endregion

    // region CRUD
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
    public ResponseEntity<String> deleteGame(@PathVariable Integer id) {
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
    // endregion

    // region Playlist
    @GetMapping("{id}/playlists")
    public ResponseEntity<PlaylistDTO> getPlaylist(@PathVariable Integer id) {
        try {
            if (id != null) {
                return ResponseEntity.ok(gameService.getPlaylist(id));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("{id}/playlists/{pId}")
    public ResponseEntity<?> setPlaylist(@PathVariable Integer id, @PathVariable Integer pId) {
        try {
            if (id != null && pId != null) {
                return ResponseEntity.ok(gameService.setPlaylist(id, pId));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // endregion

    // region Score
    @GetMapping("{id}/usergames")
    public ResponseEntity<List<UserGameDTOForGame>> getScores(@PathVariable Integer id) {
        try {
            if (id != null) {
                return ResponseEntity.ok(gameService.getScores(id));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("{id}/usergames/highscore")
    public ResponseEntity<UserGameDTOForGame> getHighScore(@PathVariable Integer id) {
        try {
            if (id != null) {
                return ResponseEntity.ok(gameService.getHighScore(id));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("{id}/usergames/{uId}")
    public ResponseEntity<?> addUserToGame(@PathVariable Integer id, @PathVariable Integer uId) {
        try {
            if (id != null && uId != null) {
                gameService.addUserToGame(id, uId);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}/usergames/{uId}")
    public ResponseEntity<String> removeUserFromGame(@PathVariable Integer id, @PathVariable Integer uId) {
        try {
            if (id != null && uId != null) {
                gameService.removeUserFromGame(id, uId);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("{id}/usergames/{uId}")
    public ResponseEntity<String> addPoints(@PathVariable Integer id, @PathVariable Integer uId, @Valid @RequestBody Integer points) {
        try {
            if (id != null && uId != null && points != null) {
                gameService.addPoints(id, uId, points);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // endregion

}
