package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Model.GameMode;
import io.ipme.neptunes.Repository.GameRepository;
import io.ipme.neptunes.Service.dto.GameDTO;
import io.ipme.neptunes.Service.dto.GameCreateUpdateDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameDTO> findAll() {
        List<GameDTO> gameDTOS = new ArrayList<>();
        for (Game game : gameRepository.findAll()) {
            GameDTO gameDTO = new GameDTO();
            BeanUtils.copyProperties(game, gameDTO);
            gameDTOS.add(gameDTO);
        }
        return gameDTOS;
    }

    public GameDTO findOne(Integer id) {
        GameDTO gameDTO = new GameDTO();
        BeanUtils.copyProperties(gameRepository.findById(id).orElseThrow(), gameDTO);
        return gameDTO;
    }

    public GameDTO createGame(GameCreateUpdateDTO gameCreateUpdateDTO) {
        Game game = new Game(gameCreateUpdateDTO.getGameUrl(), gameCreateUpdateDTO.getPaused(), gameCreateUpdateDTO.getGameMode());
        gameRepository.save(game);
        GameDTO gameDTO = new GameDTO();
        BeanUtils.copyProperties(game, gameDTO);
        return gameDTO;
    }

    public void deleteGame(Integer id) {
        // TODO : la suppression doit également supprimer les scores liés et couper l'association avec sa playlist
        gameRepository.deleteById(id);
    }

    // TODO : Mapstruct
    public GameDTO updateGame(Integer id, GameCreateUpdateDTO gameUpdateDTO) {
        // Game update
        Game game = gameRepository.findById(id).orElseThrow();

        if (gameUpdateDTO.getGameUrl() != null) game.setGameUrl(gameUpdateDTO.getGameUrl());
        if (gameUpdateDTO.getPaused() != null) game.setPaused(gameUpdateDTO.getPaused());
        if (gameUpdateDTO.getGameMode() != null) game.setGameMode(gameUpdateDTO.getGameMode());

        gameRepository.save(game);

        // GameDTO send back
        GameDTO gameDTO = new GameDTO();
        BeanUtils.copyProperties(game, gameDTO);
        return gameDTO;
    }

    public GameDTO setGameMode(Integer id, String gameMode) {
        Game game = gameRepository.findById(id).orElseThrow();
        game.setGameMode(GameMode.getMode(gameMode));
        gameRepository.save(game);
        GameDTO gameDTO = new GameDTO();
        BeanUtils.copyProperties(game, gameDTO);
        return gameDTO;
    }

}
