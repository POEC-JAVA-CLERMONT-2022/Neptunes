package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.User;
import io.ipme.neptunes.Repository.UserRepository;
import io.ipme.neptunes.Service.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
	private UserRepository userRepository;

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

	public void createUser(User user) { userRepository.saveAndFlush(user); }

	public void deleteUser(Integer id) { userRepository.deleteById(id); }

	public void updateUser(String userName, String avatar, Integer id ) { userRepository.updateUserInfos(userName, avatar, id); }

}
