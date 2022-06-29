package com.cts.authorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userrecord")
public class User {

	@Id
	@GeneratedValue()
	@Column(name = "user_id")
	private int id;

	@Column(unique = true, nullable = false,name = "user_name")
	private String username;

	@Column(name = "user_password")
	private String password;



}
