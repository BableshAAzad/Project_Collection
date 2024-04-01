package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;

	public void addMovie(int movieId, String movieName, String movieGenre, String movieDirector,
			long movieBoxOfficeCollection) {
		movieRepository.addMovie(movieId, movieName, movieGenre, movieDirector, movieBoxOfficeCollection);
	}

	public Movie findMovieById(int movieId) {
		Movie movie = movieRepository.findMovieById(movieId);
		return movie;
	}

	public String updateMovieById(int movieId, String movieName, String movieGenre, String movieDirector,
			long movieBoxOfficeCollection) {
		String updated = movieRepository.updateMovieById(movieId, movieName, movieGenre, movieDirector,
				movieBoxOfficeCollection);
		return updated;
	}

	public String deleteMovieById(int movieId) {
		String res = movieRepository.deleteMovieById(movieId);
		return res;
	}

	public Movie findMovieByName(String movieName) {
		Movie movie = movieRepository.findMovieByName(movieName);
		return movie;
	}

	public List<Movie> findAllMovies() {
		List<Movie> list = movieRepository.findAllMovies();
		return list;
	}

	public List<Movie> findAllMovesByGenre(String movieGenre) {
		List<Movie> list = movieRepository.findAllMovesByGenre(movieGenre);
		return list;
	}

	public String updateMovieCollectionByName(String movieName, long movieBoxOfficeCollection) {
		String result = movieRepository.updateMovieCollectionByName(movieName, movieBoxOfficeCollection);
		return result;
	}
	
	public int deleteAllMovieByDirector(String movieDirector) {
		int res = movieRepository.deleteAllMovieByDirector(movieDirector);
		return res;
	}
}
