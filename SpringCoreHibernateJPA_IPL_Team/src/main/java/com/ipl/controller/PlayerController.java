package com.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ipl.entity.Player;
import com.ipl.service.PlayerService;

@Controller
public class PlayerController {
	@Autowired
	private PlayerService playerService;

	public void addPlayer(int playerid, String playerName, int playerAge, String playerContry, String iplTeam,
			long iplSalary) {
		playerService.addPlayer(playerid, playerName, playerAge, playerContry, iplTeam, iplSalary);
	}

	public Player findPlayerById(int playerId) {
		Player player = playerService.findPlayerById(playerId);
		return player;
	}

	public Player findPlayerByName(String playerName) {
		Player player = playerService.findPlayerByName(playerName);
		return player;
	}

	public List<Player> findAllPlayerByContry(String playerContry) {
		List<Player> players = playerService.findAllPlayerByContry(playerContry);
		return players;
	}

	public List<Player> findAllPlayerByIplTeam(String iplTeam) {
		List<Player> players = playerService.findAllPlayerByIplTeam(iplTeam);
		return players;
	}

	public String updatePlayerAgeByPlayerId(int playerId, int playerAge) {
		String res = playerService.updatePlayerAgeByPlayerId(playerId, playerAge);
		return res;
	}
	
	public int updateAllPlayerSalaryByIplTeam(String iplTeam) {
		int res = playerService.updateAllPlayerSalaryByIplTeam(iplTeam);
		return res;
	}

	public int deletePlayerBetweenAge(int age1, int age2) {
		int res = playerService.deletePlayerBetweenAge(age1, age2);
		return res;
	}

	public int deleteAllPlayerByCountry(String playerContry) {
		int res = playerService.deleteAllPlayerByCountry(playerContry);
		return res;
	}
}
