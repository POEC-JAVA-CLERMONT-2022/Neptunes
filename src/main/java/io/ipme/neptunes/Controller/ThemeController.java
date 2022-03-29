package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("/themes")
    public List<Theme> findAll() { return themeService.findAll(); }
}
