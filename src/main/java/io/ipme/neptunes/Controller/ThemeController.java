package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Service.ThemeService;
import io.ipme.neptunes.Service.dto.ThemeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Valid
@RestController
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("/themes")
    public ArrayList<ThemeDTO> findAll() { return themeService.findAll(); }

    @GetMapping("/themes/{id}")
    public Optional<Theme> findById(@PathVariable Integer id) { return themeService.findById(id); }

    @PostMapping("/themes")
    public void createTheme(@RequestBody Theme theme) { themeService.createTheme(theme); }

    @DeleteMapping("/themes/{id}")
    public void deleteTheme(@PathVariable Integer id) { themeService.deleteTheme(id); }

    @PatchMapping("/themes/{id}")
    public void updateTheme(@RequestBody Theme theme, @PathVariable Integer id) { themeService.updateTheme(theme, id); }

}
