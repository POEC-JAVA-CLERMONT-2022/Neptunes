package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Model.GameMode;
import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Repository.GameRepository;
import io.ipme.neptunes.Service.dto.GameDTO;
import io.ipme.neptunes.Service.dto.GameCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.PlaylistDTO;
import io.ipme.neptunes.Service.dto.UserGameDTOForGame;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    // region Initialization
    private final GameRepository gameRepository;
    private final PlaylistService playlistService;
    private final UserGameService userGameService;

    public GameService(GameRepository gameRepository, PlaylistService playlistService, UserGameService userGameService) {
        this.gameRepository = gameRepository;
        this.playlistService = playlistService;
        this.userGameService = userGameService;
    }
    // endregion

    // region CRUD
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
    // endregion

    // region Playlist
    public PlaylistDTO getPlaylist(Integer id) {
        PlaylistDTO playlistDTO = new PlaylistDTO();
        BeanUtils.copyProperties(gameRepository.findById(id).orElseThrow().getPlaylist(), playlistDTO);
        return playlistDTO;
    }

    public PlaylistDTO setPlaylist(Integer id, Integer pId) {
        /*Playlist add*/
        Game game = gameRepository.findById(id).orElseThrow();
        game.setPlaylist(new Playlist(pId));
        gameRepository.save(game);

        /*PlaylistDTO send back*/
        return playlistService.findOne(pId);
    }
    // endregion

    // region Score
    public List<UserGameDTOForGame> getScores(Integer id) {
        return userGameService.findByGameId(id);
    }

    public UserGameDTOForGame getHighScore(Integer id) {
        return userGameService.findHighScore(id);
    }
    // endregion

}
