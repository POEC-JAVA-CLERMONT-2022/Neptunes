package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Model.Track;
import io.ipme.neptunes.Repository.ThemeRepository;
import io.ipme.neptunes.Repository.TrackRepository;
import io.ipme.neptunes.Service.dto.TrackCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.TrackDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {

    private TrackRepository trackRepository;

    private ThemeRepository themeRepository;

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

    public TrackDTO save(TrackCreateUpdateDTO trackCreateDTO) {
        /*Track creation*/
        Track track = new Track(trackCreateDTO.getTrackName(), trackCreateDTO.getTrackAuthor(), trackCreateDTO.getTrackReleaseYear(), trackCreateDTO.getTrackURL());
        trackRepository.save(track);
        /*TrackDTO send back*/
        TrackDTO trackDTO = new TrackDTO();
        BeanUtils.copyProperties(track, trackDTO);
        return trackDTO;
    }

    public void remove(Integer id) {
        // TODO : supprimer aussi l'association avec les playlists et des thèmes
        trackRepository.deleteById(id);
    }

    public TrackDTO update(Integer id, TrackCreateUpdateDTO trackUpdateDTO) {
        /*Track update*/
        Track track = trackRepository.findById(id).orElseThrow();

        if (trackUpdateDTO.getTrackName() != null) track.setTrackName(trackUpdateDTO.getTrackName());
        if (trackUpdateDTO.getTrackAuthor() != null) track.setTrackAuthor(trackUpdateDTO.getTrackAuthor());
        if (trackUpdateDTO.getTrackReleaseYear() != null) track.setTrackReleaseYear(trackUpdateDTO.getTrackReleaseYear());
        if (trackUpdateDTO.getTrackURL() != null) track.setTrackURL(trackUpdateDTO.getTrackURL());

        trackRepository.save(track);
        /*TrackDTO send back*/
        TrackDTO trackDTO = new TrackDTO();
        BeanUtils.copyProperties(track, trackDTO);
        return trackDTO;
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
