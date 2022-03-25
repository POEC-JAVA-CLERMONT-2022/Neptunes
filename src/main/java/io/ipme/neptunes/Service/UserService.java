package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.User;
import io.ipme.neptunes.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}


}
