package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.User;
import io.ipme.neptunes.Repository.UserRepository;
import io.ipme.neptunes.Service.dto.UserCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
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

	public void createUser(UserCreateUpdateDTO userCreateDTO) {
		User user = new User(userCreateDTO.getUserName(), userCreateDTO.getEmail(), userCreateDTO.getPassword(), userCreateDTO.getAvatar(), userCreateDTO.getPremium());
		userRepository.save(user);
	}

	public void deleteUser(Integer id) { userRepository.deleteById(id); }

	public void updateUser(Integer id, UserCreateUpdateDTO userUpdateDTO) {
		User user = userRepository.findById(id).orElseThrow();

		if (userUpdateDTO.getUserName() != null) userRepository.updateUserName(userUpdateDTO.getUserName(), id);
		if (userUpdateDTO.getEmail() != null) userRepository.updateEmail(userUpdateDTO.getEmail(), id);
		if (userUpdateDTO.getPassword() != null) userRepository.updatePassword(userUpdateDTO.getPassword(), id);
		if (userUpdateDTO.getAvatar() != null) userRepository.updateAvatar(userUpdateDTO.getAvatar(), id);
		if (userUpdateDTO.getPremium() != null) userRepository.updateIsPremium(userUpdateDTO.getPremium(), id);

		userRepository.save(user);
	}

}
