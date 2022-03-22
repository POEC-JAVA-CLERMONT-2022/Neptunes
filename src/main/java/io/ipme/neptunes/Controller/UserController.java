package io.ipme.neptunes.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ipme.neptunes.Model.User;
import io.ipme.neptunes.Service.UserService;

@RestController
public class UserController {

private UserService userService = new UserService();
	
	@GetMapping("/users")
	public ArrayList<User> getUsers() {
		return userService.getAll();
	}
	
	
	@GetMapping("/users/add")
	public String addAnimal() {
		for (int i = 0; i < 10; i++) {
        	userService.Add(new User("pseudo "+i, "pseudo"+i+"@pseudo.com", "password"+i, "avatar"+i+".jpg", false));
		}
		return "OK"; 		
	}
}
