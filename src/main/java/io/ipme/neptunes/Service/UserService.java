package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Model.User;
import io.ipme.neptunes.Repository.UserRepository;
import io.ipme.neptunes.Service.dto.PlaylistDTO;
import io.ipme.neptunes.Service.dto.UserCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    public List<PlaylistDTO> getUserPlaylists(Integer id) {
        List<PlaylistDTO> playlistDTOS = new ArrayList<>();
        User user = userRepository.findById(id).orElseThrow();
        for (Playlist playlist : user.getPlaylists()) {
            PlaylistDTO playlistDTO = new PlaylistDTO();
            BeanUtils.copyProperties(playlist, playlistDTO);
            playlistDTOS.add(playlistDTO);
        }
        return playlistDTOS;
    }

}
