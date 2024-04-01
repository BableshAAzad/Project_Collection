package com.movie;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.movie.controller.MovieController;
import com.movie.entity.Movie;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MovieController mc = ac.getBean(MovieController.class);
		int movieId = 108;
		String movieName = "Bajirao mastani";
		String movieGenre = "Comedy";
		String movieDirector = "Bhola singh";
		long movieBoxOfficeCollection = 222222222l;

//		mc.addMovie(movieId, movieName, movieGenre, movieDirector, movieBoxOfficeCollection);
//		--------------------------------------------------------------
//		Movie movieById = mc.findMovieById(movieId);
//		System.out.println(movieById);
//		--------------------------------------------------------------
//		String updated = mc.updateMovieById(movieId, movieName, movieGenre, movieDirector, movieBoxOfficeCollection);
//		System.out.println(updated);
//		--------------------------------------------------------------
//		String res = mc.deleteMovieById(movieId);
//		System.out.println(res);
//		--------------------------------------------------------------
//		Movie movie = mc.findMovieByName(movieName);
//		System.out.println(movie);
//		--------------------------------------------------------------
//		List<Movie> allMovies = mc.findAllMovies();
//		for(Movie m : allMovies) {
//			System.out.println(m);
//		}
//		--------------------------------------------------------------
//		List<Movie> listMovies = mc.findAllMovesByGenre(movieGenre);
//		for(Movie m : listMovies) {
//			System.out.println(m);
//		}
//		--------------------------------------------------------------
		String result = mc.updateMovieCollectionByName(movieName, movieBoxOfficeCollection);
		System.out.println(result);
//		--------------------------------------------------------------
//		int res = mc.deleteAllMovieByDirector(movieDirector);
//		System.out.println(res + " records deleted");
	}
}
