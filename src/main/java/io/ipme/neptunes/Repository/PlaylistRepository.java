package io.ipme.neptunes.Repository;

import io.ipme.neptunes.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    @Modifying
    @Query(
            value = "SELECT id FROM track, (SELECT id AS sid FROM track ORDER BY RAND( ) LIMIT :limit) tmp WHERE track.id = tmp.sid;",
            nativeQuery = true
    )

    List<Integer> getRandomTracks(@Param("limit") Integer limit);
}