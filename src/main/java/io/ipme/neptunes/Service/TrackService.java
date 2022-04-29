package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Model.Track;
import io.ipme.neptunes.Repository.ThemeRepository;
import io.ipme.neptunes.Repository.TrackRepository;
import io.ipme.neptunes.Service.dto.TrackDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {

    private TrackRepository trackRepository;

    private ThemeRepository themeRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository, ThemeRepository themeRepository) {
        this.trackRepository = trackRepository;
        this.themeRepository = themeRepository;
    }

    public List<TrackDTO> findAll() {
        List<TrackDTO> trackDTOS = new ArrayList<>();
        for (Track track : trackRepository.findAll()) {
            TrackDTO trackDTO = new TrackDTO();
            BeanUtils.copyProperties(track, trackDTO);
            trackDTOS.add(trackDTO);
        }
        return trackDTOS;
    }

    public TrackDTO findOne(Integer id) {
        TrackDTO trackDTO = new TrackDTO();
        BeanUtils.copyProperties(trackRepository.findById(id).orElseThrow(), trackDTO);
        return trackDTO;
    }

    public TrackDTO save(TrackDTO trackDTO) {
        Track track = new Track(trackDTO.getTrackName(), trackDTO.getTrackAuthor(), trackDTO.getTrackReleaseYear(), trackDTO.getTrackURL());
        trackRepository.save(track);
        return trackDTO;
    }

    public void remove(Integer id) {
        trackRepository.deleteById(id);
    }

    public void update(Track track, Integer id) {

        Track trackToUpdate = trackRepository.getById(id);
        trackToUpdate.setTrackName(track.getTrackName().isBlank() ? trackToUpdate.getTrackName() : track.getTrackName());
        trackToUpdate.setTrackAuthor(track.getTrackAuthor().isBlank() ? trackToUpdate.getTrackAuthor() : track.getTrackAuthor());
        trackToUpdate.setTrackURL(track.getTrackURL().isBlank() ? trackToUpdate.getTrackAuthor() : track.getTrackURL());
        trackToUpdate.setTrackReleaseYear(track.getTrackReleaseYear() == null ? trackToUpdate.getTrackReleaseYear() : track.getTrackReleaseYear());
        trackToUpdate.setTrackReleaseYear(track.getTrackReleaseYear() == null ? trackToUpdate.getTrackReleaseYear() : track.getTrackReleaseYear());

        trackRepository.save(trackToUpdate);
    }

    public void setTheme(Integer trackId, ArrayList<Integer> themeIds) {
        Track track = trackRepository.findById(trackId).orElseThrow();
        for (Integer id : themeIds) {
            Theme theme = themeRepository.findById(id).orElseThrow();
            theme.getTracks().add(track);
            track.getThemes().add(theme);
        }
        trackRepository.saveAndFlush(track);
    }

    public void deleteTheme(Integer trackId, Integer themeId) {
        Track track = trackRepository.findById(trackId).orElseThrow();
        track.getThemes().remove(themeRepository.findById(themeId).orElseThrow());
        trackRepository.saveAndFlush(track);
    }

}
