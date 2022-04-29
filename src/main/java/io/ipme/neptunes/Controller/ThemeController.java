package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Service.ThemeService;
import io.ipme.neptunes.Service.dto.ThemeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("themes")
public class ThemeController {

    private ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping
    public ResponseEntity<List<ThemeDTO>> findAll() {
        try {
            return ResponseEntity.ok(themeService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ThemeDTO> findById(@PathVariable Integer id) {
        try {
            if (id != null) {
                return ResponseEntity.ok(themeService.findById(id));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createTheme(@RequestBody ThemeDTO themeDTO) {
        try {
            if (themeDTO != null) {
                return ResponseEntity.ok(themeService.createTheme(themeDTO));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTheme(@PathVariable Integer id) {
        try {
            if (id != null) {
                themeService.deleteTheme(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> updateTheme(@PathVariable Integer id, @RequestBody ThemeDTO themeDTO) {
        try {
            if (id != null && themeDTO != null) {
                return ResponseEntity.ok(themeService.updateTheme(id, themeDTO));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
