package com.autodialer.authService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "oauth_user_role")
public class UserRole {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oauth_user_role_id")
	private Long oauthUserRoleId;

	private UserAccount user;

	private Role role;

}
