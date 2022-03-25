package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Track;
import io.ipme.neptunes.Service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping("/tracks")
    public List<Track> getAll(){
      return trackService.findAll();
    }
}