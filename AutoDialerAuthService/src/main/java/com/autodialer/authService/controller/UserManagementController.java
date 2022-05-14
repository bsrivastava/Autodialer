package com.autodialer.authService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.autodialer.authService.model.UserAccountDto;
import com.autodialer.authService.model.UserAccountModel;
import com.autodialer.authService.services.UserManagementServices;

@RestController
public class UserManagementController {
	
	@Autowired
	private UserManagementServices userManagementServices;

	@PostMapping("/createuser")
	private ResponseEntity<UserAccountDto> createUser(@RequestBody UserAccountModel userAccountModel) {
		UserAccountDto body = userManagementServices.createUser(userAccountModel);
		return new ResponseEntity<UserAccountDto>(body,HttpStatus.ACCEPTED);
		}
	
	
}
