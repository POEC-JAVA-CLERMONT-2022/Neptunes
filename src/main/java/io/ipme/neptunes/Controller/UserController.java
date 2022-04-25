package io.ipme.neptunes.Controller;

import io.ipme.neptunes.Service.UserService;
import io.ipme.neptunes.Service.dto.UserCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		try {
			return ResponseEntity.ok().body(userService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(userService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping
	public ResponseEntity createUser(@RequestBody UserCreateUpdateDTO userCreateDTO) {
		try {
			if (userCreateDTO != null) {
				userService.createUser(userCreateDTO);
				return ResponseEntity.ok(HttpStatus.CREATED);
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity deleteUser(@PathVariable Integer id) {
		try {
			if (id != null) {
				userService.deleteUser(id);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PatchMapping("{id}")
	public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody UserCreateUpdateDTO userUpdateDTO) {
		try {
			if (userUpdateDTO != null) {
				userService.updateUser(id, userUpdateDTO);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
