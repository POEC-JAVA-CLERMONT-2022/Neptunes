package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Model.Track;
import io.ipme.neptunes.Repository.ThemeRepository;
import io.ipme.neptunes.Service.dto.ThemeCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.ThemeDTO;
import io.ipme.neptunes.Service.dto.TrackDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThemeService {

    // region Initialization
    private final ThemeRepository themeRepository;
    private final TrackService trackService;

    public ThemeService(ThemeRepository themeRepository, TrackService trackService) {
        this.themeRepository = themeRepository;
        this.trackService = trackService;
    }
    // endregion

    // region CRUD
    public List<ThemeDTO> findAll() {
        List<ThemeDTO> themeDTOS = new ArrayList<>();
        for (Theme theme : themeRepository.findAll()) {
            ThemeDTO themeDTO = new ThemeDTO();
            BeanUtils.copyProperties(theme, themeDTO);
            themeDTOS.add(themeDTO);
        }
        return themeDTOS;
    }

    public ThemeDTO findById(Integer id) {
        ThemeDTO themeDTO = new ThemeDTO();
        BeanUtils.copyProperties(themeRepository.findById(id).orElseThrow(), themeDTO);
        return themeDTO;
    }

    public ThemeDTO createTheme(ThemeCreateUpdateDTO themeCreateDTO) {
        /*Theme creation*/
        Theme theme = new Theme(themeCreateDTO.getTheme());
        themeRepository.save(theme);
        /*ThemeDTO send back*/
        ThemeDTO themeDTO = new ThemeDTO();
        BeanUtils.copyProperties(theme, themeDTO);
        return themeDTO;
    }

    public void deleteTheme(Integer id) {
        themeRepository.deleteById(id);
    }

    public ThemeDTO updateTheme(Integer id, ThemeCreateUpdateDTO themeUpdateDTO) {
        // Theme update
        Theme theme = themeRepository.findById(id).orElseThrow();
        if (themeUpdateDTO.getTheme() != null) theme.setTheme(themeUpdateDTO.getTheme());
        themeRepository.save(theme);
        // ThemeDTO send back
        ThemeDTO themeDTO = new ThemeDTO();
        BeanUtils.copyProperties(theme, themeDTO);
        return themeDTO;
    }
    // endregion

    //region Track
    public List<TrackDTO> getTracks(Integer id) {
        List<TrackDTO> trackDTOS = new ArrayList<>();
        for (Track track : themeRepository.findById(id).orElseThrow().getTracks()) {
            TrackDTO trackDTO = new TrackDTO();
            BeanUtils.copyProperties(track, trackDTO);
            trackDTOS.add(trackDTO);
        }
        return trackDTOS;
    }

    public void addTrack(Integer id, Integer trId) {
        trackService.setTheme(trId, id);
    }

    public void removeTrack(Integer id, Integer trId) throws Exception {
        Theme theme = themeRepository.findById(id).orElseThrow();
        if (theme.getTracks().contains(new Track(trId))) {
            trackService.deleteTheme(trId, id);
        } else throw new Exception("La track indiquée n'appartient pas à ce thème !");
    }
    // endregion

}
