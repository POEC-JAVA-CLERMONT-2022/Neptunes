package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/playlists")
    public ResponseEntity<List<Playlist>> getAll(){

        try {
            return ResponseEntity.ok().body(playlistService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/playlists/{id}")
    public ResponseEntity<Optional<Playlist>> getOne(@PathVariable Integer id) {

        Optional<Playlist> playlist = Optional.empty();
        try {
            if (id != null) {
              playlist = playlistService.findOne(id);
            }
            return ResponseEntity.ok().body(playlist);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
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
    public ResponseEntity<Playlist> deletePlaylist(@RequestBody Playlist playlist, @PathVariable Integer id) {

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
