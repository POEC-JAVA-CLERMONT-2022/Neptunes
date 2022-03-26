package io.ipme.neptunes.Repository;

import io.ipme.neptunes.Model.Track;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrackRepository extends JpaRepository<Track, Integer> {

}
