package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Repository.ThemeRepository;
import io.ipme.neptunes.Service.dto.ThemeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    public ArrayList<ThemeDTO> findAll() {
        ArrayList<ThemeDTO> themesDTO = new ArrayList<>();
        for(Theme theme : themeRepository.findAll()) {
            themesDTO.add(new ThemeDTO(theme.getTheme()));
        }
        return themesDTO;
    }

    public Optional<Theme> findById(Integer id) { return themeRepository.findById(id); }

    public void createTheme(Theme theme) { themeRepository.saveAndFlush(theme); }

    public void deleteTheme(Integer id) { themeRepository.deleteById(id); }

    public void updateTheme(Theme theme, Integer id) {
        Theme themeToUpdate = themeRepository.getById(id);
        themeToUpdate.setTheme(theme.getTheme());
        themeRepository.save(themeToUpdate);
    }

}
