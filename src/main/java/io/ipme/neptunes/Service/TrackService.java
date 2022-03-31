package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Track;
import io.ipme.neptunes.Repository.TrackRepository;
import io.ipme.neptunes.Service.dto.TrackDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public List<TrackDTO> findAll(){
        ArrayList<TrackDTO> playlistDtos = new ArrayList<>();
        for (Track playlist : trackRepository.findAll()){
            TrackDTO playlistDto = new TrackDTO();
            BeanUtils.copyProperties(playlist, playlistDto);
            playlistDtos.add(playlistDto);
        }
        return playlistDtos;
    }

    public TrackDTO findOne(Integer id){

        TrackDTO playlistDto = new TrackDTO();
        BeanUtils.copyProperties(trackRepository.findById(id).orElseThrow(), playlistDto);
        return playlistDto;
    }

    public void save(Track track){
        trackRepository.saveAndFlush(track);
    }

    public void remove(Integer id){
        trackRepository.deleteById(id);
    }

    public void update(Track track, Integer id){

        Track trackToUpdate  = trackRepository.getById(id);
        trackToUpdate.setTrackName(track.getTrackName().isBlank() ? trackToUpdate.getTrackName() : track.getTrackName());
        trackToUpdate.setTrackAuthor(track.getTrackAuthor().isBlank() ? trackToUpdate.getTrackAuthor() : track.getTrackAuthor());
        trackToUpdate.setTrackURL(track.getTrackURL().isBlank() ? trackToUpdate.getTrackAuthor() : track.getTrackURL());
        trackToUpdate.setTrackReleaseYear(track.getTrackReleaseYear() ==  null ? trackToUpdate.getTrackReleaseYear() : track.getTrackReleaseYear());
        trackToUpdate.setTrackReleaseYear(track.getTrackReleaseYear() ==  null ? trackToUpdate.getTrackReleaseYear() : track.getTrackReleaseYear());

        trackRepository.save(trackToUpdate);
    }
}
