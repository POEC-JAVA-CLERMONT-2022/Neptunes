package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Track;
import io.ipme.neptunes.Service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> getAll(){
        try {
            return ResponseEntity.ok().body(trackService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/tracks/{id}")
    public ResponseEntity<Optional<Track>> getOne(@PathVariable Integer id){
        try {
            if (id != null){
                return ResponseEntity.ok().body(trackService.findOne(id));
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PostMapping("/tracks")
    public ResponseEntity<Track> createTrack(@RequestBody Track track) {
        try {
            if (track != null){
                trackService.save(track);
            }
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/tracks/{id}")
    public ResponseEntity<Track> removeTrack(@RequestBody @PathVariable Integer id) {
        try {
            if (id != null){
                trackService.remove(id);
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PatchMapping("/tracks/{id}")
    public ResponseEntity<Track> updateTrack(@RequestBody Track track, @PathVariable Integer id) {
        try {
            if (id != null && track != null){
                trackService.update(track, id);
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
}