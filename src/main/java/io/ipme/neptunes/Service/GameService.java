package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Repository.GameRepository;
import io.ipme.neptunes.Service.dto.GameDTO;
import io.ipme.neptunes.Service.dto.UpdateGameDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.ipme.neptunes.Model.GameMode;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) { this.gameRepository = gameRepository; }

    public ArrayList<GameDTO> findAll() {
        ArrayList<GameDTO> gameDTOS = new ArrayList<>();
        for (Game game : gameRepository.findAll()) {
            gameDTOS.add(new GameDTO(game.getId(), game.getGameUrl(), game.getPaused(), game.getMode()));
        }
        return gameDTOS;
    }

    public GameDTO findOne(Integer id) {
        GameDTO gameDTO = new GameDTO();
        BeanUtils.copyProperties(gameRepository.findById(id).orElseThrow(), gameDTO);
        return gameDTO;
    }

    public void createGame(GameDTO gameDTO) {
        gameRepository.saveAndFlush(new Game());
    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

    public void setGameMode(Integer id, String gameMode) {
        Game game = gameRepository.findById(id).orElseThrow();
        game.setMode(GameMode.getMode(gameMode));
        gameRepository.save(game);
    }

    public void updateGame(Integer id, UpdateGameDTO updateGameDTO) {
        Game game = gameRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(updateGameDTO, game, getNullPropertyNames(updateGameDTO));
        gameRepository.save(game);
    }

    //TODO : mapstruct
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        HashSet<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
