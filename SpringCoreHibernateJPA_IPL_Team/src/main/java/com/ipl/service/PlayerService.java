package com.ipl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl.entity.Player;
import com.ipl.repository.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepository playerRepository;

	public void addPlayer(int playerid, String playerName, int playerAge, String playerContry, String iplTeam,
			long iplSalary) {
		playerRepository.addPlayer(playerid, playerName, playerAge, playerContry, iplTeam, iplSalary);
	}

	public Player findPlayerById(int playerId) {
		Player player = playerRepository.findPlayerById(playerId);
		return player;
	}

	public Player findPlayerByName(String playerName) {
		Player player = playerRepository.findPlayerByName(playerName);
		return player;
	}

	public List<Player> findAllPlayerByContry(String playerContry) {
		List<Player> players = playerRepository.findAllPlayerByContry(playerContry);
		return players;
	}

	public List<Player> findAllPlayerByIplTeam(String iplTeam) {
		List<Player> players = playerRepository.findAllPlayerByIplTeam(iplTeam);
		return players;
	}

	public String updatePlayerAgeByPlayerId(int playerId, int playerAge) {
		String res = playerRepository.updatePlayerAgeByPlayerId(playerId, playerAge);
		return res;
	}

	public int updateAllPlayerSalaryByIplTeam(String iplTeam) {
		int res = playerRepository.updateAllPlayerSalaryByIplTeam(iplTeam);
		return res;
	}

	public int deletePlayerBetweenAge(int age1, int age2) {
		int res = playerRepository.deletePlayerBetweenAge(age1, age2);
		return res;
	}

	public int deleteAllPlayerByCountry(String playerContry) {
		int res = playerRepository.deleteAllPlayerByCountry(playerContry);
		return res;
	}
}
