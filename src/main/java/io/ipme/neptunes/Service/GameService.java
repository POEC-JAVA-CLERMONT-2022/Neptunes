package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Game;
import io.ipme.neptunes.Repository.GameRepository;
import io.ipme.neptunes.Service.dto.GameDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.ipme.neptunes.Model.GameMode;

import java.util.ArrayList;

@Service
    public class GameService {

    @Autowired
    private GameRepository gameRepository;

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
        if(gameMode.equals("Normal")){
            game.setMode(GameMode.Normal);
        } else if (gameMode.equals("Faster")){
            game.setMode(GameMode.Faster);
        } else if (gameMode.equals("Random")){
            game.setMode(GameMode.Random);
        } else {
            game.setMode(GameMode.Normal);
        }
        gameRepository.save(game);
    }

    /*public void getGameMode(String gameMode){
        GameMode.getMode(gameMode);
    }*/
}
