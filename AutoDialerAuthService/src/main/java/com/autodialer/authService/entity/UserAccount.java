package com.autodialer.authService.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="oauth_user")
public class UserAccount {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	
	private String email;
	
	private String phoneNumber;
	
	private String password;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String userName;
	
	private Date createdAt;
	
	private Date updateAt;
	
}
