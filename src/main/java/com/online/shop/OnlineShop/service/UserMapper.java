package com.online.shop.OnlineShop.service;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.online.shop.OnlineShop.model.AuthResponse;
import com.online.shop.OnlineShop.model.User;

@Component
public class UserMapper {

	
	public UserMapper() {
		super();
	}

	private final ModelMapper modelMapper = new ModelMapper();

	public AuthResponse convertToAuthResponse(User user) {
		return modelMapper.map(user, AuthResponse.class);
	}
	
	public User convertToUser(AuthResponse authResponse) {
		return modelMapper.map(authResponse, User.class);
	}
}
