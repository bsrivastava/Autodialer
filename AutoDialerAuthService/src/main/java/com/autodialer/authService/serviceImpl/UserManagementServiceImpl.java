package com.autodialer.authService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.autodialer.authService.convertor.UserManagementConvertor;
import com.autodialer.authService.model.UserAccountDto;
import com.autodialer.authService.model.UserAccountModel;
import com.autodialer.authService.services.UserManagementServices;

public class UserManagementServiceImpl implements UserManagementServices {

	@Autowired
	private UserManagementConvertor userManagementConvertor;

	@Override
	public UserAccountDto createUser(UserAccountModel userAccountModel) {
		UserAccountDto userAccount = userManagementConvertor.convertUserModel(userAccountModel);
		return userAccount;
	}
}
