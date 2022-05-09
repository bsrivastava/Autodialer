package com.autodialer.authService.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
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
@Table(name="user_licence")
public class Licence implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name="user_licence_id")
	private Long userLicenceId;
	
	private String userLicence;
	
	@OneToOne()
	private UserAccount user;
	
	private Boolean active;
	
	private Date createdAt;
	
	private Date updateAt;
	
}
