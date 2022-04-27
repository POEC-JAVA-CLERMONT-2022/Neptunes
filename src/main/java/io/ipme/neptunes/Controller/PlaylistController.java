package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Service.PlaylistService;
import io.ipme.neptunes.Service.dto.PlaylistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("playlists")
public class PlaylistController {


    private PlaylistService playlistService;

    @Autowired
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
                return ResponseEntity.ok().body(playlistService.findOne(id));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity createPlaylist(@RequestBody Playlist playlist) {

        try {
            if (playlist != null) {
                playlistService.save(playlist);
                return ResponseEntity.ok(HttpStatus.CREATED);
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
    public ResponseEntity<String> updatePlaylist(@RequestBody Playlist playlist, @PathVariable Integer id) {

        try {
            if (id != null) {
                playlistService.update(playlist, id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
