package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Model.User;
import io.ipme.neptunes.Repository.UserRepository;
import io.ipme.neptunes.Service.dto.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    // region Initialization
    private UserRepository userRepository;
    private PlaylistService playlistService;
    private UserGameService userGameService;

    public UserService(UserRepository userRepository, PlaylistService playlistService, UserGameService userGameService) {
        this.userRepository = userRepository;
        this.playlistService = playlistService;
        this.userGameService = userGameService;
    }
    // endregion

    // region CRUD
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
    // endregion

    // region Playlist
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
        User user = userRepository.findById(id).orElseThrow();
        if (user.getPlaylists().contains(new Playlist(pId))) {
            return playlistService.findOne(pId);
        } else throw new RuntimeException("L'utilisateur ne possède pas la playlist indiquée");
    }

    public PlaylistDTO addPlaylist(Integer id, PlaylistCreateUpdateDTO playlistCreateDTO) {
        /*Playlist creation*/
        PlaylistDTO playlistDTO = playlistService.save(playlistCreateDTO);

        /*Add Playlist*/
        User user = userRepository.findById(id).orElseThrow();
        user.getPlaylists().add(new Playlist(playlistDTO.getId()));
        userRepository.save(user);

        /*PlaylistDTO send back*/
        return playlistDTO;
    }

    public void deletePlaylist(Integer id, Integer pId) throws Exception {
        User user = userRepository.findById(id).orElseThrow();
        Playlist playlist = new Playlist(playlistService.findOne(pId).getId());
        if (user.getPlaylists().contains(playlist)) {
            user.getPlaylists().remove(playlist);
            playlistService.remove(pId);
            userRepository.save(user);
        } else throw new Exception("Vous ne pouvez pas supprimer une playlist qui vous ne possédez pas !");
    }
    // endregion

    // region Score
    public List<UserGameDTOForUser> getScores(Integer id) {
        return userGameService.findByUserId(id);
    }

    public UserGameDTOForUser getScoreForGame(Integer id, Integer gId) {
        return userGameService.findByUserIdAndGameId(id, gId);
    }
    // endregion
}
