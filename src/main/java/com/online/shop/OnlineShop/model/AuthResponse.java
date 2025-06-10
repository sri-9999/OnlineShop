package com.online.shop.OnlineShop.model;

public class AuthResponse {
	private String userId;
	private String email;
	private String role;
	private boolean isActive;
	private boolean authStatus;

	public AuthResponse(String userId, String email, String role, boolean isActive, boolean authStatus) {
		this.userId = userId;
		this.email = email;
		this.role = role;
		this.isActive = isActive;
		this.authStatus = authStatus;
	}

	public AuthResponse() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(boolean authStatus) {
		this.authStatus = authStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AuthResponse [userId=" + userId + ", role=" + role + ", email=" + email + ", isActive=" + isActive
				+ ", authStatus=" + authStatus + "]";
	}

	
}
