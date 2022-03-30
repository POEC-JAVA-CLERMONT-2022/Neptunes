package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Track;
import io.ipme.neptunes.Service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Valid
@RestController
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> getAll(){
        try {
            return ResponseEntity.ok().body(trackService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/tracks/{id}")
    public ResponseEntity<Optional<Track>> getOne(@PathVariable Integer id){
        try {
            if (id != null) {
                return ResponseEntity.ok().body(trackService.findOne(id));
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/tracks")
    public ResponseEntity<String> createTrack(@RequestBody Track track) {
        try {
            if (track != null){
                trackService.save(track);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/tracks/{id}")
    public ResponseEntity<String> removeTrack(@RequestBody @PathVariable Integer id) {
        try {
            if (id != null){
                trackService.remove(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/tracks/{id}")
    public ResponseEntity<String> updateTrack(@RequestBody Track track, @PathVariable Integer id) {
        try {
            if (id != null && track != null){
                trackService.update(track, id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}