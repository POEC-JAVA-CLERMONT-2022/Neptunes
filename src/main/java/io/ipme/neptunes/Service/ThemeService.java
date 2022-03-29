package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    public List<Theme> findAll() {
        return themeRepository.findAll();
    }
}
