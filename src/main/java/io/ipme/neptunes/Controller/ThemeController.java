package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Service.ThemeService;
import io.ipme.neptunes.Service.dto.ThemeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("themes")
public class ThemeController {

    private ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<ThemeDTO>> findAll() {
        try {
            return ResponseEntity.ok(themeService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Theme> findById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(themeService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity createTheme(@RequestBody Theme theme) {
        themeService.createTheme(theme);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public void deleteTheme(@PathVariable Integer id) {
        themeService.deleteTheme(id);
    }

    @PatchMapping("{id}")
    public void updateTheme(@RequestBody Theme theme, @PathVariable Integer id) {
        themeService.updateTheme(theme, id);
    }

}
