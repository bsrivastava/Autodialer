package com.autodialer.authService.services;

import org.springframework.stereotype.Service;

import com.autodialer.authService.entity.UserAccount;
import com.autodialer.authService.model.UserAccountDto;
import com.autodialer.authService.model.UserAccountModel;

@Service
public interface UserManagementServices {

	public UserAccountDto createUser(UserAccountModel userAccountModel);
	
	
}
