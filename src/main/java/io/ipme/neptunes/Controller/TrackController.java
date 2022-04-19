package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Track;
import io.ipme.neptunes.Service.TrackService;
import io.ipme.neptunes.Service.dto.TrackDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("tracks")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping
    public ResponseEntity<List<TrackDTO>> getAll(){
        try {
            return ResponseEntity.ok().body(trackService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<TrackDTO> getOne(@Valid @PathVariable Integer id){
        try {
            if (id != null) {
                return ResponseEntity.ok().body(trackService.findOne(id));
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createTrack(@RequestBody @Valid Track track) {
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

    @DeleteMapping("{id}")
    public ResponseEntity<String> removeTrack(@Valid @RequestBody @PathVariable Integer id) {
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

    @PatchMapping("{id}") // PutMapping
    public ResponseEntity<String> updateTrack(@Valid @RequestBody Track track, @Valid @PathVariable Integer id) {
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

    @PutMapping("{id}")
    public ResponseEntity<String> updateTrack(@RequestBody Integer themeId, @PathVariable Integer id) {
        try {
            if ( themeId != null && id != null ) {
                trackService.setTheme(id, themeId);
                return ResponseEntity.ok().build();
            }
                return  ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}