package com.autodialer.authService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "oauth_role")
public class Role {

	@Column(name = "role_id")
	public Long roleId;

	public String role;

}
