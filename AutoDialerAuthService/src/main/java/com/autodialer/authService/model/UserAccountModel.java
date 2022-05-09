package com.autodialer.authService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountModel {

	private Long userId;
	
	private String licenceKey;
	
	private String roleId;
	
	private String email;
	
	private String phoneNumber;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String password;
	
	private String userName;
		
}
