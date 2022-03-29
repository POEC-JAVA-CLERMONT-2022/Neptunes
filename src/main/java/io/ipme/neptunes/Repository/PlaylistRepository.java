package io.ipme.neptunes.Repository;

import io.ipme.neptunes.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
}