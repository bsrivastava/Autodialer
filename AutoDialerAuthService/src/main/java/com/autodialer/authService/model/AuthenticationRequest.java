package com.autodialer.authService.model;

import lombok.Data;

@Data
public class AuthenticationRequest {

	private String userName;
	private String password;

	public AuthenticationRequest() {
	}

	public AuthenticationRequest(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
	}
}
