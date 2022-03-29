package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class GameService {

        @Autowired
        private GameRepository gameRepository;

        public List<Game> findAll() {
            return gameRepository.findAll();
        }

        public Optional<Game> findOne(Integer id){
            return gameRepository.findById(id);
        }

        public void createGame(Game game){
            gameRepository.saveAndFlush(game);
        }

        public void deleteGame(Integer id){
            gameRepository.deleteById(id);
        }
    }
