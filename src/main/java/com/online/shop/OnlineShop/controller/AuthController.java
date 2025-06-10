package com.online.shop.OnlineShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shop.OnlineShop.model.AuthResponse;
import com.online.shop.OnlineShop.model.User;
import com.online.shop.OnlineShop.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		// Basic validation (expand as needed)
		AuthResponse authResponse = new AuthResponse();
		if (user.getUserId() == null || user.getUserId().length() < 3) {
			return ResponseEntity.badRequest().body("Invalid userId");
		}
		if (user.getPassword() == null || !user.getPassword()
				.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&].{8,}")) {
			return ResponseEntity.badRequest().body("Invalid password");
		}
		if (user.getEmail() == null || !user.getEmail().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
			return ResponseEntity.badRequest().body("Invalid email");
		}
		if (this.authService.existsByUserIdOrEmail(user.getUserId(), user.getEmail())) {
			return ResponseEntity.badRequest().body("User already exists");
		}
		authResponse = this.authService.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(authResponse);
	}
	
	@PostMapping("/validateUser")
	public ResponseEntity<AuthResponse> validateUser(@RequestBody User user) {
		AuthResponse authResponse = new AuthResponse();
		authResponse = this.authService.validateUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(authResponse);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<AuthResponse>> findAllUSers() {
		List<AuthResponse> allUsers = this.authService.findAllUsers();
		
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
	
	@PostMapping("/updateUser")
	public ResponseEntity<AuthResponse> updateUserDetails(@RequestBody User user) {
		AuthResponse authResponse = new AuthResponse();
		
		this.authService.updateUser(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(authResponse);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getUserByUserId(@PathVariable String userId) {
		return this.authService.findByUserId(userId).<ResponseEntity<?>>map(ResponseEntity::ok)
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"));
	}

	@GetMapping("/user/email")
	public ResponseEntity<?> getUserByEmail(@RequestHeader("email") String email) {
	    return this.authService.findByEmail(email)
	            .<ResponseEntity<?>>map(ResponseEntity::ok)
	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"));
	}

}
