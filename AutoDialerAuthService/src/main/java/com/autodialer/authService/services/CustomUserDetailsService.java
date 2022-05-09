package com.autodialer.authService.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.autodialer.authService.entity.UserAccount;
import com.autodialer.authService.repository.UserAccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccount userdetails = userAccountRepository.findByUserName(username);

		return new User(userdetails.getUserName(), userdetails.getPassword(), new ArrayList<GrantedAuthority>());
	}

}
