package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.ipme.neptunes.Model.User;
import io.ipme.neptunes.Service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
	
	@GetMapping("/users")
	public List<UserDTO> findAll() { return userService.findAll(); }

	@GetMapping("/users/{id}")
	public UserDTO findById(@PathVariable Integer id) { return userService.findById(id); }

	@PostMapping("/users")
	public void createUser(@RequestBody User user) { userService.createUser(user); }

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) { userService.deleteUser(id); }

	@PatchMapping("/users/{id}")
	public void updateNameUser(@RequestParam String userName, @RequestParam String avatar, @PathVariable Integer id) { userService.updateUser(userName, avatar, id); }

}
