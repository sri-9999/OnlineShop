package com.online.shop.OnlineShop.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shop.OnlineShop.model.AuthResponse;
import com.online.shop.OnlineShop.model.User;
import com.online.shop.OnlineShop.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	public boolean existsByUserIdOrEmail(String userId, String email) {
		return this.userRepository.existsByUserIdOrEmail(userId, email);
	}

	public AuthResponse save(User user) {
		this.userRepository.save(user);
		return new AuthResponse(user.getUserId(), user.getEmail(), user.getRole(), user.isIsActive(), true);
	}

	public Optional<User> findByUserId(String userId) {
		return this.userRepository.findByUserId(userId);
	}

	public Optional<User> findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	public AuthResponse validateUser(User user) {
		Optional<User> result = this.userRepository.findByUserId(user.getUserId());
		if (result.isPresent() && user.getPassword().equals(result.get().getPassword())) {
			return new AuthResponse(result.get().getUserId(),  null, result.get().getRole(), result.get().isIsActive(),
					true);
		}
		return new AuthResponse();
	}


	public List<AuthResponse> findAllUsers() {
		Collection<User> users = this.userRepository.findAll();
		return users.stream().map(this.userMapper::convertToAuthResponse).collect(Collectors.toList());
	}

	public void updateUser(User user) {
		Optional<User> result = this.userRepository.findByUserId(user.getUserId());
		if(result.isPresent()) {
			User updatedUser = result.get();
			updatedUser.setRole(user.getRole());
			updatedUser.setIsActive(true);
			this.userRepository.save(updatedUser);
		}
	}

}
