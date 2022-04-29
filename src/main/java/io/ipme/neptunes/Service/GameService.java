package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Repository.GameRepository;
import io.ipme.neptunes.Service.dto.GameDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.ipme.neptunes.Model.GameMode;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) { this.gameRepository = gameRepository; }

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

    public GameDTO createGame(GameDTO gameDTO) {
        Game game = new Game(gameDTO.getGameUrl(), gameDTO.getPaused(), gameDTO.getGameMode());
        gameRepository.save(game);
        return gameDTO;
    }

    public void deleteGame(Integer id) {
        // TODO : la suppression doit également supprimer les scores liés et couper l'association avec sa playlist
        gameRepository.deleteById(id);
    }

    // TODO : Mapstruct
    public GameDTO updateGame(Integer id, GameDTO gameDTO) {
        // Game update
        Game game = gameRepository.findById(id).orElseThrow();

        if (gameDTO.getGameUrl() != null) game.setGameUrl(gameDTO.getGameUrl());
        if (gameDTO.getPaused() != null) game.setPaused(gameDTO.getPaused());
        if (gameDTO.getGameMode() != null) game.setGameMode(gameDTO.getGameMode());

        gameRepository.save(game);

        // GameDTO send back
        GameDTO gameDTOToReturn = new GameDTO();
        BeanUtils.copyProperties(game, gameDTOToReturn);
        return gameDTOToReturn;
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
