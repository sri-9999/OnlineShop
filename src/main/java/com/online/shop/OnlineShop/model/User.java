package com.online.shop.OnlineShop.model;

public class User {
	
	private String userId;
	private String password;
	private String email;
	private String role;
	private boolean isActive;

	public User() {
	}

	public User(String userId, String password, String email, String role, boolean isactive) {
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.role = role;
		this.isActive = isactive;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isactive) {
		this.isActive = isactive;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", email=" + email + ", role=" + role
				+ ", isactive=" + isActive + "]";
	}

}
