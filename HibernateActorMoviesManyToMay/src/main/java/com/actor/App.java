package com.actor;

import java.util.Scanner;

import com.actor.Service.ActorService;
import com.actor.entity.Actor;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Below options : ");
		System.out.println("1 : Add Actor\n2 : Find Actor By Id\n3 : Find Actor By Name\n4 : Find Actor By Industry");
		System.out.println(
				"5 : Update All Actors Address Between Age \n6 : Find All Actors By Movie Name \n7 : Delete Actor By Id ");
		System.out.println("8 : Delete All Actors By Nationality \n9 : Delete All Actors by Genre");
		System.out.println("---------------------------------------------------------");
		System.out.println(
				"10 : Add Movie\n11 : Find Movie By Id\n12 : Find All Movies By Language\n13 : Find All Movies Between(?, ?) BoxOfficeCollection");
		System.out.println(
				"14 : Update BoxOfficeVerdict By BoxOfficeCollection\n15 : Find All Movies By ActorName\n16 : Delete All Movies ByDirector");
		System.out.println("17 : Delete All Movies By Actor Industry");
		int n = sc.nextInt();
		ActorService actorService = new ActorService();
		switch (n) {
		case 1:
			System.out.println("Enter Actor Id : ");
			int actorId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Actor Actor Name : ");
			String actorName = sc.nextLine();
			System.out.println("Enter Actor Age : ");
			int actorAge = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Actor Address : ");
			String actorAddress = sc.nextLine();
			System.out.println("Enter Actor Industry : ");
			String industry = sc.nextLine();
			System.out.println("Enter Actor Nationality : ");
			String nationality = sc.nextLine();

			Actor actor = new Actor();
			actor.setActorId(actorId);
			actor.setActorName(actorName);
			actor.setActorAge(actorAge);
			actor.setActorAddress(actorAddress);
			actor.setIndustry(industry);
			actor.setNationality(nationality);

			actorService.addActor(actor);
			break;
		case 2:
			System.out.println("Enter Actor Id : ");
			int actorId2 = sc.nextInt();
			actorService.findActorById(actorId2);
			break;
		case 3:
			System.out.println("Enter Actor Name : ");
			sc.nextLine();
			String actorName2 = sc.nextLine();
			actorService.findActorByName(actorName2);
			break;
		case 4:
			System.out.println("Enter Actor Industry : ");
			sc.nextLine();
			String industry2 = sc.nextLine();
			actorService.findAllActorByIndustry(industry2);
			break;
		case 5:
			break;
		case 6:
			System.out.println("Enter Movie Name : ");
			sc.nextLine();
			String movieName = sc.nextLine();
			actorService.findAllActorsByMovieName(movieName);
			break;
		case 7:
			System.out.println("Enter Actor Id : ");
			int actorId1 = sc.nextInt();
			actorService.deleteActorById(actorId1);
			break;
		case 8:
			System.out.println("Enter Actor Nationality : ");
			sc.nextLine();
			String nationality1 = sc.nextLine();
			actorService.deleteAllActorsByNationality(nationality1);
			break;
		case 9:
			System.out.println("Enter Genre Name : ");
			sc.nextLine();
			String genre = sc.nextLine();
			actorService.deleteAllActorsByMovieGenre(genre);
			break;
		case 10:
			System.out.println("Enter Movie Id : ");
			int movieId = sc.nextInt();
			System.out.println("Enter Movie Name : ");
			sc.nextLine();
			String movieName2 = sc.nextLine();
			System.out.println("Enter Movie Language : ");
			String language = sc.nextLine();
			System.out.println("Enter Movie Director : ");
			String director = sc.nextLine();
			System.out.println("Enter Movie Genre : ");
			String genre1 = sc.nextLine();
			System.out.println("Enter Box Office Collection : ");
			int boxOfficeCollection = sc.nextInt();
			System.out.println("Enter Box Office Verdict : ");
			sc.nextLine();
			String boxOfficeVerdict = sc.nextLine();
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			break;
		case 16:
			break;
		case 17:
			break;
		default:
			break;
		}
	}
}
