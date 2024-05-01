package com.actor;

import java.util.Scanner;

import com.actor.Service.ActorService;
import com.actor.Service.MovieServiec;
import com.actor.entity.Actor;
import com.actor.entity.Movie;

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
		System.out.println(
				"17 : Delete All Movies By Actor Industry\n18 : Get All Movies\n19 : Get all Actors\n00 : for EXIT");
		int n = sc.nextInt();
		ActorService actorService = new ActorService();
		MovieServiec movieServiec = new MovieServiec();
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
			System.out.println("Enter Actor age1(like 35) : ");
			int actorAge1 = sc.nextInt();
			System.out.println("Enter Actor age2(like 65) : ");
			int actorAge2 = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Actors New Address : ");
			String actorAddress1 = sc.nextLine();
			actorService.updateAllActorsAddressBetweenAge(actorAge1, actorAge2, actorAddress1);
			break;
		case 6:
			System.out.println("Enter Movie Name : ");
			sc.nextLine();
			String movieName = sc.nextLine();
			System.out.println("--------------------------------------------");
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
			Movie movie = new Movie();
			movie.setMovieId(movieId);
			movie.setMovieName(movieName2);
			movie.setLanguage(language);
			movie.setDirector(director);
			movie.setGenre(genre1);
			movie.setBoxOfficeCollection(boxOfficeCollection);
			movie.setBoxOfficeVerdict(boxOfficeVerdict);
//		Display All Actor 	
			actorService.getAllActors();
			System.out.println("Enter Actor ids format(101,102,103.....) : ");
			String actorIds = sc.nextLine();

			movieServiec.addMovie(movie, actorIds);
			break;
		case 11:
			System.out.println("Enter Movie Id : ");
			int movieId1 = sc.nextInt();
			movieServiec.findMovieById(movieId1);
			break;
		case 12:
			System.out.println("Enter Movie Language : ");
			sc.nextLine();
			String language1 = sc.nextLine();
			movieServiec.findAllMoviesByLanguage(language1);
			break;
		case 13:
			System.out.println("Enter first boxOfficeCollection value : ");
			int boxOfficeCollection1 = sc.nextInt();
			System.out.println("Enter second boxOfficeCollection value : ");
			int boxOfficeCollection2 = sc.nextInt();
			movieServiec.findAllMoviesBetweenBoxOfficeCollection(boxOfficeCollection1, boxOfficeCollection2);
			break;
		case 14:
			System.out.println("Enter BoxOffice Collection (like 5000000) : ");
			int boxOfficeCollection3 = sc.nextInt();
			System.out.println("Enter boxOfficeVerdict (like BLOCK BUSTER) : ");
			sc.nextLine();
			String boxOfficeVerdict1 = sc.nextLine();
			movieServiec.updateBoxOfficeVerdictByBoxOfficeCollection(boxOfficeCollection3, boxOfficeVerdict1);
			break;
		case 15:
			System.out.println("Enter Actor Name : ");
			sc.nextLine();
			String actorName11 = sc.nextLine();
			movieServiec.findAllMoviesByActorName(actorName11);
			break;
		case 16:
			System.out.println("Enter Director Name : ");
			sc.nextLine();
			String director1 = sc.nextLine();
			movieServiec.deleteAllMoviesByDirector(director1);
			break;
		case 17:
			System.out.println("Enter movie industry : ");
			sc.nextLine();
			String industry1 = sc.nextLine();
			movieServiec.deleteAllMoviesByActorIndustry(industry1);
			break;
		case 18:
			movieServiec.getAllMovies();
			break;
		case 19:
			actorService.getAllActors();
			break;
		default:
			System.out.println("Thanks for visiting......!!!");
			break;
		}
	}
}
