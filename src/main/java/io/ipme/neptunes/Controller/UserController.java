package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Service.PlaylistService;
import io.ipme.neptunes.Service.UserService;
import io.ipme.neptunes.Service.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("users")
// TODO : throw(new Exception) / Classe Exception personnalisable
public class UserController {

    /*
        Initialisation
     */
    private UserService userService;
    private PlaylistService playlistService;

    public UserController(UserService userService, PlaylistService playlistService) {
        this.userService = userService;
        this.playlistService = playlistService;
    }

    /*
        CRUD Mapping
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        try {
            return ResponseEntity.ok(userService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        try {
            if (id != null) {
                return ResponseEntity.ok(userService.findById(id));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateUpdateDTO userCreateDTO) {
        try {
            if (userCreateDTO != null) {
                UserDTO userDTO = userService.createUser(userCreateDTO);
                return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        try {
            if (id != null) {
                userService.deleteUser(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @Valid @RequestBody UserCreateUpdateDTO userUpdateDTO) {
        try {
            if (userUpdateDTO != null) {
                UserDTO userDTO = userService.updateUser(id, userUpdateDTO);
                return ResponseEntity.ok().body(userDTO);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /*
        Playlist's Methods Mapping
     */
    @GetMapping("{id}/playlists")
    public ResponseEntity<List<PlaylistDTO>> getPlaylists(@PathVariable Integer id) {
        try {
            if (id != null) {
                return ResponseEntity.ok(userService.getPlaylists(id));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("{id}/playlists/{pId}")
    public ResponseEntity<PlaylistDTO> getPlaylistById(@PathVariable Integer id, @PathVariable Integer pId) {
        try {
            if (id != null && pId != null) {
                return ResponseEntity.ok(userService.getPlaylistById(id, pId));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("{id}/playlists")
    public ResponseEntity<?> addPlaylist(@PathVariable Integer id, @Valid @RequestBody PlaylistCreateUpdateDTO playlistCreateDTO) {
        try {
            if (id != null && playlistCreateDTO != null) {
                return ResponseEntity.ok(userService.addPlaylist(id, playlistCreateDTO));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}/playlists/{pId}")
    public ResponseEntity<String> deletePlaylist(@PathVariable Integer id, @PathVariable Integer pId) {
        try {
            if (id != null && pId != null) {
                userService.deletePlaylist(id, pId);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /*
        Score's Methods Mapping
     */
    @GetMapping("{id}/usergames")
    public ResponseEntity<List<UserGameDTOForUser>> getScores(@PathVariable Integer id) {
        try {
            if (id != null) {
                return ResponseEntity.ok(userService.getScores(id));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("{id}/usergames/{gId}")
    public ResponseEntity<UserGameDTOForUser> getScoreForGame(@PathVariable Integer id, @PathVariable Integer gId) {
        try {
            if (id != null && gId != null) {
                return ResponseEntity.ok(userService.getScoreForGame(id, gId));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}