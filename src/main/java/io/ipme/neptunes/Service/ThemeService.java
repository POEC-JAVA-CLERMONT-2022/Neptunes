package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    public List<Theme> findAll() { return themeRepository.findAll(); }

    public Optional<Theme> findById(Integer id) { return themeRepository.findById(id); }

    public ResponseEntity<Theme> createTheme(Theme theme) {
        themeRepository.saveAndFlush(theme);
        return ResponseEntity.ok().build();
    }

    public void deleteTheme(Integer id) { themeRepository.deleteById(id); }

    public void updateTheme(Theme theme, Integer id) {
        Theme themeToUpdate = themeRepository.getById(id);
        themeToUpdate.setTheme(theme.getTheme());
        themeRepository.save(themeToUpdate);
    }

}
