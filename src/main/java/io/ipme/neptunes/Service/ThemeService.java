package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Repository.ThemeRepository;
import io.ipme.neptunes.Service.dto.ThemeCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.ThemeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThemeService {

    private ThemeRepository themeRepository;

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
        // TODO : la suppression de theme doit également supprimer l'association avec la musique
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

}
