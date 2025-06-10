package com.online.shop.OnlineShop.repository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.online.shop.OnlineShop.model.AuthResponse;
import com.online.shop.OnlineShop.model.User;

import java.util.*;

@Repository
public class UserRepository {

	private static final Map<String, User> usersByEmail = new HashMap<>();
	private static final Map<String, User> usersById = new HashMap<>();

	static {
		// Initialize Admin user
		User admin = new User("Admin", "Admin@1234", "admin@gmail.com", "ADMIN", true);

		// Initialize regular User
		User user = new User("User", "User@1234", "user@gmail.com", "USER", true);

		usersById.put(admin.getUserId(), admin);
		usersById.put(user.getUserId(), user);
		
		usersByEmail.put(admin.getEmail(), admin);
		usersByEmail.put(user.getEmail(), user);
	}

	public UserRepository() {
		super();
	}

	public User save(User user) {
		usersById.put(user.getUserId(), user);
		usersByEmail.put(user.getEmail(), user);
		return user;
	}

	public Optional<User> findByUserId(String userId) {
		return Optional.ofNullable(usersById.get(userId));
	}

	public Optional<User> findByEmail(String email) {
		return Optional.ofNullable(usersByEmail.get(email));
	}

	public boolean existsByUserIdOrEmail(String userId, String email) {
		return usersById.containsKey(userId) || usersByEmail.containsKey(email);
	}

	public Collection<User> findAll() {
		return usersById.values();

	}

}
