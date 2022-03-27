package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Track;
import io.ipme.neptunes.Service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping("/tracks")
    public List<Track> getAll(){
      return trackService.findAll();
    }

    @GetMapping("/track/{id}")
    public Optional<Track> getOne(@PathVariable Integer id){
        return trackService.findOne(id);
    }

    @PostMapping("/track/add")
    public void createTrack(@RequestBody Track track) {
        trackService.save(track);
    }
    @PostMapping("/track/remove/{id}")
    public void createTrack(@RequestBody @PathVariable Integer id) {
        trackService.remove(id);
    }

    @PutMapping("/track/update/{id}")
    public void updateTrack(@RequestBody Track track, @PathVariable Integer id) {
        trackService.update(track, id);
    }
}