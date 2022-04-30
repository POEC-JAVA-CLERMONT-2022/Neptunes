package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Service.TrackService;
import io.ipme.neptunes.Service.dto.TrackCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.TrackDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("tracks")
//TODO : utiliser des logger !!!
public class TrackController {

    private TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public ResponseEntity<List<TrackDTO>> getAll() {
        try {
            return ResponseEntity.ok(trackService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<TrackDTO> getOne(@PathVariable Integer id) {
        try {
            if (id != null) {
                return ResponseEntity.ok(trackService.findOne(id));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createTrack(@Valid @RequestBody TrackCreateUpdateDTO trackCreateDTO) {
        try {
            if (trackCreateDTO != null) {
                return ResponseEntity.ok(trackService.save(trackCreateDTO));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> removeTrack(@PathVariable Integer id) {
        try {
            if (id != null) {
                trackService.remove(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> updateTrack(@PathVariable Integer id, @Valid @RequestBody TrackCreateUpdateDTO trackUpdateDTO) {
        try {
            if (id != null && trackUpdateDTO != null) {
                return ResponseEntity.ok(trackService.update(id, trackUpdateDTO));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> setThemes(@RequestBody ArrayList<Integer> themeIds, @PathVariable Integer id) {
        try {
            if (themeIds != null && id != null) {
                trackService.setTheme(id, themeIds);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}/themes/{themeId}")
    public ResponseEntity<String> deleteTheme(@PathVariable Integer id, @PathVariable Integer themeId) {
        try {
            if (id != null && themeId != null) {
                trackService.deleteTheme(id, themeId);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}