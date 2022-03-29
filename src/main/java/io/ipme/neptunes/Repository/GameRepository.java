package io.ipme.neptunes.Repository;

import io.ipme.neptunes.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public interface GameRepository extends JpaRepository<Game, Long> {

        List<Game> findAll();
    }
