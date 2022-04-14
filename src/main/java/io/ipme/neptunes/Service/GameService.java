package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Model.GameMode;
import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Repository.GameRepository;
import io.ipme.neptunes.Service.dto.GameDTO;
import io.ipme.neptunes.Service.dto.PlaylistDTO;
import io.ipme.neptunes.Service.dto.ThemeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
    public class GameService {

        @Autowired
        private GameRepository gameRepository;

    public ArrayList<GameDTO> findAll() {
        ArrayList<GameDTO> gameDTOS = new ArrayList<>();
        for(Game game : gameRepository.findAll()) {
            gameDTOS.add(new GameDTO(game.getGameUrl()));
        }
        return gameDTOS;
    }

    public GameDTO findOne(Integer id){

        GameDTO gameDTO = new GameDTO();
        BeanUtils.copyProperties(gameRepository.findById(id).orElseThrow(), gameDTO);
        return gameDTO;
    }

        public void createGame(GameDTO gameDTO){
            gameRepository.saveAndFlush(new Game());
        }

        public void deleteGame(Integer id){
            gameRepository.deleteById(id);
        }
    }
