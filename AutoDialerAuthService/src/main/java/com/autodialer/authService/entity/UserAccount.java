package com.autodialer.authService.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter 
@Setter 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="oauth_user")
public class UserAccount {

	@Id
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
	
	//mapping
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "oauth_user_role", joinColumns = {
			@JoinColumn(name = "user_id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id") })
	Set<Role> roles = new HashSet<>();
	
	@OneToOne(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE, CascadeType.MERGE, CascadeType.PERSIST })
	private Licence licence;
		
}
