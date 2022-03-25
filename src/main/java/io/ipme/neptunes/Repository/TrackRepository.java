package io.ipme.neptunes.Repository;

import io.ipme.neptunes.Model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Integer> {


    List<Track> findAll();
}
