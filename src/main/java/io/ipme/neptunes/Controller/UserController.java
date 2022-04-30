package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Service.PlaylistService;
import io.ipme.neptunes.Service.UserService;
import io.ipme.neptunes.Service.dto.PlaylistDTO;
import io.ipme.neptunes.Service.dto.UserCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
// TODO : throw(new Exception) / Classe Exception personnalisable
public class UserController {

    private UserService userService;
    private PlaylistService playlistService;

    public UserController(UserService userService, PlaylistService playlistService) {
        this.userService = userService;
        this.playlistService = playlistService;
    }

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

    @GetMapping("{id}/playlists")
    public ResponseEntity<List<PlaylistDTO>> getUserPlaylists(@PathVariable Integer id) {
        try {
            if (id != null) {
                return ResponseEntity.ok(userService.getUserPlaylists(id));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}