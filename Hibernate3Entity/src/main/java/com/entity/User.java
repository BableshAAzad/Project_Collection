package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	@Id
	private int userId;
	private String userName;
	private String userEmail;
	private int userAge;
	@OneToOne
	private Cart cart;
}
