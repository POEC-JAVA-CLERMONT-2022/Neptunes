package io.ipme.neptunes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.ipme.neptunes.Model.User;
import io.ipme.neptunes.Service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/users/{id}")
	public Optional<User> findById(@PathVariable Integer id) { return userService.findById(id); }

	@PostMapping("/users")
	public void createUser(@RequestBody User user) { userService.createUser(user); }

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) { userService.deleteUser(id); }

	@PatchMapping("/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable Integer id) { userService.updateUser(user, id); }

}
