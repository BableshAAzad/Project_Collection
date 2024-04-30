package com.actor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Actor {
	@Id
	private int actorId;
	private String actorName;
	private int actorAge;
	private String actorAddress;
	private String industry;
	private String nationality;
	@ManyToMany
	private List<Movie> movies;
}
