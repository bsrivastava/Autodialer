package com.autodialer.authService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDto {

	private String userName;
	private String email;
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private String licenceKey;

	
	
}
