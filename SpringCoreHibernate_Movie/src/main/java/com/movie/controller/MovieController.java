package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.movie.entity.Movie;
import com.movie.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;

	public void addMovie(int movieId, String movieName, String movieGenre, String movieDirector,
			long movieBoxOfficeCollection) {
		movieService.addMovie(movieId, movieName, movieGenre, movieDirector, movieBoxOfficeCollection);
	}

	public Movie findMovieById(int movieId) {
		Movie movie = movieService.findMovieById(movieId);
		return movie;
	}

	public String updateMovieById(int movieId, String movieName, String movieGenre, String movieDirector,
			long movieBoxOfficeCollection) {
		String updated = movieService.updateMovieById(movieId, movieName, movieGenre, movieDirector,
				movieBoxOfficeCollection);
		return updated;
	}

	public String deleteMovieById(int movieId) {
		String res = movieService.deleteMovieById(movieId);
		return res;
	}

	public Movie findMovieByName(String movieName) {
		Movie movie = movieService.findMovieByName(movieName);
		return movie;
	}

	public List<Movie> findAllMovies() {
		List<Movie> list = movieService.findAllMovies();
		return list;
	}

	public List<Movie> findAllMovesByGenre(String movieGenre) {
		List<Movie> list = movieService.findAllMovesByGenre(movieGenre);
		return list;
	}

	public String updateMovieCollectionByName(String movieName, long movieBoxOfficeCollection) {
		String result = movieService.updateMovieCollectionByName(movieName, movieBoxOfficeCollection);
		return result;
	}

	public int deleteAllMovieByDirector(String movieDirector) {
		int res = movieService.deleteAllMovieByDirector(movieDirector);
		return res;
	}
}
