package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Service.PlaylistService;
import io.ipme.neptunes.Service.dto.PlaylistCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.PlaylistDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("playlists")
public class PlaylistController {


    private PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public ResponseEntity<List<PlaylistDTO>> getAll() {
        try {
            return ResponseEntity.ok().body(playlistService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<PlaylistDTO> getOne(@PathVariable Integer id) {
        try {
            if (id != null) {
                return ResponseEntity.ok(playlistService.findOne(id));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createPlaylist(@Valid @RequestBody PlaylistCreateUpdateDTO playlistCreateDTO) {
        try {
            if (playlistCreateDTO != null) {
                return ResponseEntity.ok(playlistService.save(playlistCreateDTO));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePlaylist(@PathVariable Integer id) {
        try {
            if (id != null) {
                playlistService.remove(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> updatePlaylist(@PathVariable Integer id, @Valid @RequestBody PlaylistCreateUpdateDTO playlistUpdateDTO) {
        try {
            if (id != null && playlistUpdateDTO != null) {
                return ResponseEntity.ok(playlistService.update(id, playlistUpdateDTO));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("{id}/tracks")
    public ResponseEntity<?> addTracks(@PathVariable Integer id, @RequestBody List<Integer> tracksId) {
        try {
            if (id != null && tracksId != null) {
                return ResponseEntity.ok(playlistService.addTracks(id, tracksId));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}/tracks")
    public ResponseEntity<?> removeTracks(@PathVariable Integer id, @RequestBody List<Integer> tracksId) {
        try {
            if (id != null && tracksId != null) {
                return ResponseEntity.ok(playlistService.removeTracks(id, tracksId));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("random/{limit}")
    public ResponseEntity<?> generateRandomPlaylist(@PathVariable Integer limit) {
        try {
            if (limit != null) {
                return ResponseEntity.ok(playlistService.generateRandomPlaylist(limit));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
