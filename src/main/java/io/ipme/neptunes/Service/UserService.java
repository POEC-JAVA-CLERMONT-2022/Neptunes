package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Model.User;
import io.ipme.neptunes.Model.UserGame;
import io.ipme.neptunes.Repository.PlaylistRepository;
import io.ipme.neptunes.Repository.UserGameRepository;
import io.ipme.neptunes.Repository.UserRepository;
import io.ipme.neptunes.Service.dto.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    /*
        Initialisation
     */
    private UserRepository userRepository;
    private PlaylistRepository playlistRepository;
    private UserGameRepository userGameRepository;

    public UserService(UserRepository userRepository, PlaylistRepository playlistRepository, UserGameRepository userGameRepository) {
        this.userRepository = userRepository;
        this.playlistRepository = playlistRepository;
        this.userGameRepository = userGameRepository;
    }

    /*
        CRUD Methods
     */
    public List<UserDTO> findAll() {
        ArrayList<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    public UserDTO findById(Integer id) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userRepository.findById(id).orElseThrow(), userDTO);
        return userDTO;
    }

    public UserDTO createUser(UserCreateUpdateDTO userCreateDTO) {
        User user = userRepository.save(new User(userCreateDTO.getUserName(), userCreateDTO.getEmail(), userCreateDTO.getPassword(), userCreateDTO.getAvatar(), userCreateDTO.getPremium()));
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    public void deleteUser(Integer id) {
        // TODO : Voir avec une constructeur avec seulement un id (pour playlist de user)
        userRepository.deleteById(id);
    }

    public UserDTO updateUser(Integer id, UserCreateUpdateDTO userUpdateDTO) {
        /*User update*/
        User user = userRepository.findById(id).orElseThrow();

        if (userUpdateDTO.getUserName() != null) user.setUserName(userUpdateDTO.getUserName());
        if (userUpdateDTO.getEmail() != null) user.setEmail(userUpdateDTO.getEmail());
        if (userUpdateDTO.getPassword() != null) user.setPassword(userUpdateDTO.getPassword());
        if (userUpdateDTO.getAvatar() != null) user.setAvatar(userUpdateDTO.getAvatar());
        if (userUpdateDTO.getPremium() != null) user.setPremium(userUpdateDTO.getPremium());

        userRepository.save(user);

        /*UserDTO send back*/
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    /*
        Playlists Methods
     */
    public List<PlaylistDTO> getPlaylists(Integer id) {
        List<PlaylistDTO> playlistDTOS = new ArrayList<>();
        User user = userRepository.findById(id).orElseThrow();
        for (Playlist playlist : user.getPlaylists()) {
            PlaylistDTO playlistDTO = new PlaylistDTO();
            BeanUtils.copyProperties(playlist, playlistDTO);
            playlistDTOS.add(playlistDTO);
        }
        return playlistDTOS;
    }

    public PlaylistDTO getPlaylistById(Integer id, Integer pId) {
        PlaylistDTO playlistDTO = new PlaylistDTO();
        User user = userRepository.findById(id).orElseThrow();
        Playlist playlist = playlistRepository.findById(pId).orElseThrow();
        if (user.getPlaylists().contains(playlist)) {
            BeanUtils.copyProperties(playlist, playlistDTO);
            return playlistDTO;
        } else throw new RuntimeException("L'utilisateur ne possède pas la playlist indiquée");
    }

    public PlaylistDTO addPlaylist(Integer id, PlaylistCreateUpdateDTO playlistCreateDTO) {
        /*Playlist creation*/
        Playlist playlist = new Playlist(playlistCreateDTO.getName(), playlistCreateDTO.getRandom());
        playlistRepository.save(playlist);

        /*Add Playlist*/
        User user = userRepository.findById(id).orElseThrow();
        user.getPlaylists().add(playlist);
        userRepository.save(user);

        /*PlaylistDTO send back*/
        PlaylistDTO playlistDTO = new PlaylistDTO();
        BeanUtils.copyProperties(playlist, playlistDTO);
        return playlistDTO;
    }

    public void deletePlaylist(Integer id, Integer pId) {
        User user = userRepository.findById(id).orElseThrow();
        Playlist playlist = playlistRepository.findById(pId).orElseThrow();
        if (user.getPlaylists().contains(playlist)) {
            user.getPlaylists().remove(playlist);
            playlistRepository.deleteById(pId);
            userRepository.save(user);
        } else throw new RuntimeException("Vous ne pouvez pas supprimer une playlist qui vous ne possédez pas !");
    }

    /*
        Scores Methods
     */
    public List<UserGameDTOForUser> getScores(Integer id) {
        List<UserGameDTOForUser> userGameDTOForUsers = new ArrayList<>();
        for (UserGame userGame : userGameRepository.findByUserGamePK_user_Id(id)) {
            UserGameDTOForUser userGameDTOForUser = new UserGameDTOForUser();
            BeanUtils.copyProperties(userGame, userGameDTOForUser);
            userGameDTOForUser.setGameId(userGame.getUserGamePK().getGame().getId());
            userGameDTOForUsers.add(userGameDTOForUser);
        }
        return userGameDTOForUsers;
    }

    public UserGameDTOForUser getScoreForGame(Integer id, Integer gId) {
        UserGameDTOForUser userGameDTO = new UserGameDTOForUser();
        BeanUtils.copyProperties(userGameRepository.findByUserGamePK_user_idAndUserGamePK_game_id(id, gId), userGameDTO);
        userGameDTO.setGameId(gId);
        return userGameDTO;
    }

}
