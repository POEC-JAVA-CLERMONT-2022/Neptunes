package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Service.PlaylistService;
import io.ipme.neptunes.Service.dto.PlaylistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/playlists")
    public ResponseEntity<List<PlaylistDTO>> getAll(){

        try {
            return ResponseEntity.ok().body(playlistService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/playlists/{id}")
    public ResponseEntity<PlaylistDTO> getOne(@PathVariable Integer id) {

        try {
            if (id != null) {
                return ResponseEntity.ok().body(playlistService.findOne(id));
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/playlists")
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {

        try {
            if (playlist != null){
                playlistService.save(playlist);
            }
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/playlists/{id}")
    public ResponseEntity<Playlist> deletePlaylist(@RequestBody @PathVariable Integer id) {

        try {
            if (id != null){
                playlistService.remove(id);
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PatchMapping("/playlists/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@RequestBody Playlist playlist, @PathVariable Integer id) {

        try {
            if (id != null){
                playlistService.update(playlist, id);
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
}
