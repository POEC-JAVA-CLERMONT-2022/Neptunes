package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Repository.ThemeRepository;
import io.ipme.neptunes.Service.dto.ThemeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThemeService {

    private ThemeRepository themeRepository;

    @Autowired
    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

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

    public ThemeDTO createTheme(ThemeDTO themeDTO) {
        Theme theme = new Theme(themeDTO.getTheme());
        themeRepository.save(theme);
        return themeDTO;
    }

    public void deleteTheme(Integer id) {
        // TODO : la suppression de theme doit également supprimer l'association avec la musique
        themeRepository.deleteById(id);
    }

    public ThemeDTO updateTheme(Integer id, ThemeDTO themeDTO) {
        // Theme update
        Theme theme = themeRepository.findById(id).orElseThrow();
        if (themeDTO.getTheme() != null) theme.setTheme(themeDTO.getTheme());
        themeRepository.save(theme);
        // ThemeDTO send back
        ThemeDTO themeDTOToReturn = new ThemeDTO();
        BeanUtils.copyProperties(theme, themeDTOToReturn);
        return themeDTOToReturn;
    }

}
