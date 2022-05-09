package com.autodialer.authService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autodialer.authService.model.AuthenticationRequest;
import com.autodialer.authService.model.AuthenticationResponse;
import com.autodialer.authService.services.CustomUserDetailsService;
import com.autodialer.authService.utils.JwTUtils;


@RestController
public class AuthenticationController {

	@Autowired
	private JwTUtils jwtUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@GetMapping("/")
	public String welcome() {
		return "Welcome To MyApp";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("invalid userName or Passowrd!", e);
		}
		final UserDetails userDetails = customUserDetailsService
				.loadUserByUsername(authenticationRequest.getUserName());

		final String jwt = jwtUtils.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
