package io.ipme.neptunes.Repository;

import io.ipme.neptunes.Model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {
}
