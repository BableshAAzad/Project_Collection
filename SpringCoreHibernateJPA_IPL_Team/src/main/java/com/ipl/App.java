package com.ipl;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ipl.controller.PlayerController;
import com.ipl.entity.Player;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		PlayerController playerController = ac.getBean(PlayerController.class);
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose Below options : ");
			System.out.println("1 :- for Add Playaers");
			System.out.println("2 :- for findPlayerById");
			System.out.println("3 :- for findPlayerByName");
			System.out.println("4 :- for findAllPlayerByContry");
			System.out.println("5 :- for findAllPlayerByIplTeam");
			System.out.println("6 :- for updatePlayerAgeByPlayerId");
			System.out.println("7 :- for updateAllPlayerSalaryByIplTeam(salary+200000)");
			System.out.println("8 :- for deletePlayerBetweenAge");
			System.out.println("9 :- for deleteAllPlayerByCountry");
			System.out.println("10 :- for exit");
			int n = sc.nextInt();
			if (n == 1) {
				System.out.println("Enter player playerId : ");
				int playerId = sc.nextInt();
				System.out.println("Enter player playerName : ");
				String playerName = sc.next();
				System.out.println("Enter player playerAge : ");
				int playerAge = sc.nextInt();
				System.out.println("Enter player playerContry : ");
				String playerContry = sc.next();
				System.out.println("Enter player iplTeam : ");
				String iplTeam = sc.next();
				System.out.println("Enter player iplSalary : ");
				long iplSalary = sc.nextLong();
				playerController.addPlayer(playerId, playerName, playerAge, playerContry, iplTeam, iplSalary);
				continue;
			} else if (n == 2) {
				System.out.println("Enter Player Id : ");
				int playerId1 = sc.nextInt();
				Player player = playerController.findPlayerById(playerId1);
				System.out.println(player);
				continue;
			} else if (n == 3) {
				System.out.println("Enter Player Name : ");
				String playerName = sc.next();
				Player player = playerController.findPlayerByName(playerName);
				System.out.println(player);
			} else if (n == 4) {
				System.out.println("Enter Player Contry : ");
				String playerContry = sc.next();
				List<Player> players = playerController.findAllPlayerByContry(playerContry);
				for (Player p : players) {
					System.out.println(p);
				}
			} else if (n == 5) {
				System.out.println("Enter iplTeam name : ");
				String iplTeam = sc.next();
				List<Player> players = playerController.findAllPlayerByIplTeam(iplTeam);
				for (Player p : players) {
					System.out.println(p);
				}
			} else if (n == 6) {
				System.out.println("Enter playerId : ");
				int playerId = sc.nextInt();
				System.out.println("Enter New PlayerAge : ");
				int playerAge = sc.nextInt();
				String res = playerController.updatePlayerAgeByPlayerId(playerId, playerAge);
				System.out.println(res);
			} else if (n == 7) {
				System.out.println("Enter iplTeam name : ");
				String iplTeam = sc.next();
				int res = playerController.updateAllPlayerSalaryByIplTeam(iplTeam);
				System.out.println(res + " players are updated");
			} else if (n == 8) {
				System.out.println("Enter Age1 : ");
				int age1 = sc.nextInt();
				System.out.println("Enter Age2 : ");
				int age2 = sc.nextInt();
				int res = playerController.deletePlayerBetweenAge(age1, age2);
				System.out.println(res + " records deleted");
			} else if (n == 9) {
				System.out.println("Enter Contry Name : ");
				String playerContry = sc.next();
				int res = playerController.deleteAllPlayerByCountry(playerContry);
				System.out.println(res + " records deleted");
			} else if (n == 10) {
				System.out.println("*******Thanks*******");
				sc.close();
				break;
			} else {
				System.out.println("Please Enter correct input");
			}
		}
	}
}
