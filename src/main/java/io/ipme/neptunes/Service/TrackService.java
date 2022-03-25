package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Track;
import io.ipme.neptunes.Repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public List<Track> findAll(){
        return trackRepository.findAll();
    }
}
