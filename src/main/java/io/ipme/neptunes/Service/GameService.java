package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class GameService {

        @Autowired
        private GameRepository gameRepository;

        public List<Game> findAll() { return gameRepository.findAll(); }
    }
