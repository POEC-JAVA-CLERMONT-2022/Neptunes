package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Model.Track;
import io.ipme.neptunes.Repository.TrackRepository;
import io.ipme.neptunes.Service.dto.ThemeDTO;
import io.ipme.neptunes.Service.dto.TrackCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.TrackDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {

    // region Initialization
    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    // endregion

    // region CRUD
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
    // endregion

    // region Themes
    public List<ThemeDTO> getThemes(Integer id) {
        List<ThemeDTO> themeDTOS = new ArrayList<>();
        for (Theme theme : trackRepository.findById(id).orElseThrow().getThemes()) {
            ThemeDTO themeDTO = new ThemeDTO();
            BeanUtils.copyProperties(theme, themeDTO);
            themeDTOS.add(themeDTO);
        }
        return themeDTOS;
    }

    public void setTheme(Integer id, Integer thId) {
        Track track = trackRepository.findById(id).orElseThrow();
        track.getThemes().add(new Theme(thId));
        trackRepository.save(track);
    }

    public void deleteTheme(Integer id, Integer thId) {
        Track track = trackRepository.findById(id).orElseThrow();
        track.getThemes().remove(new Theme(thId));
        trackRepository.save(track);
    }
    // endregion

}
