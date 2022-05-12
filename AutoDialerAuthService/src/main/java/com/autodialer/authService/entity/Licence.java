package com.autodialer.authService.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_licence_id")
	private Long userLicenceId;
	
	private String userLicence;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private UserAccount user;
	
	private Boolean active;
	
	private Date createdAt;
	
	private Date updateAt;
	
}
