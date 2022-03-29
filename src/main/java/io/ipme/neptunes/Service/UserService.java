package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.User;
import io.ipme.neptunes.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
	private UserRepository userRepository;

	public List<User> findAll() { return userRepository.findAll(); }

	public Optional<User> findById(Integer id) { return userRepository.findById(id); }

	public void createUser(User user) { userRepository.saveAndFlush(user); }

	public void deleteUser(Integer id) { userRepository.deleteById(id); }

	public void updateUser(User user, Integer id) {
		User userToUpdate = userRepository.getById(id);
		userToUpdate.setUserName(user.getUserName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setAvatar(user.getAvatar());
		userToUpdate.setPremium(user.getPremium());
		userRepository.save(userToUpdate);
	}

}
