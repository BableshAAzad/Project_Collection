package com.ipl.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Player {
	@Id
	private int playerId;
	private String playerName;
	private int playerAge;
	private String playerContry;
	private String iplTeam;
	private long iplSalary;
}
