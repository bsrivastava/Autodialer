package com.autodialer.authService.convertor;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autodialer.authService.entity.Licence;
import com.autodialer.authService.entity.UserAccount;
import com.autodialer.authService.model.UserAccountDto;
import com.autodialer.authService.model.UserAccountModel;
import com.autodialer.authService.repository.UserAccountRepository;

@Component
public class UserManagementConvertor {
	
	@Autowired
	private UserAccountRepository userAccountRepository;

	public UserAccountDto convertUserModel(UserAccountModel userAccountModel) {
		
		UserAccount userAccount = new UserAccount();
		userAccount.setEmail(userAccountModel.getEmail());
		userAccount.setFirstName(userAccountModel.getFirstName());
		userAccount.setMiddleName(userAccountModel.getMiddleName());
		userAccount.setLastName(userAccountModel.getLastName());
		userAccount.setUserName(userAccountModel.getUserName());
		userAccount.setPhoneNumber(userAccountModel.getPhoneNumber());
		
		Licence licence = new Licence();
		licence.setUser(userAccount);
		licence.setActive(true);
		
		String licenceGenerated  = UUID.randomUUID().toString();
		licence.setUserLicence(licenceGenerated);
		
		UserAccount savedUser = userAccountRepository.save(userAccount);
		
		UserAccountDto userAccountDto = new UserAccountDto();
		userAccountDto.setEmail(savedUser.getEmail());
		userAccountDto.setFirstName(savedUser.getFirstName());
		userAccountDto.setMiddleName(savedUser.getMiddleName());
		userAccountDto.setPhoneNumber(savedUser.getPhoneNumber());
		userAccountDto.setUserName(savedUser.getUserName());
		//userAccountDto.setLicenceKey(savedUser.getLic);
		return userAccountDto;
	}

}
