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

    /*public ResponseEntity<Theme> save(Theme theme) {
        themeRepository.saveAndFlush(theme);
        return ResponseE;
    }*/


}
