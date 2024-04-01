package com.movie.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	private int movieId;
	private String movieName;
	private String movieGenre;
	private String movieDirector;
	private long movieBoxOfficeCollection;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public long getMovieBoxOfficeCollection() {
		return movieBoxOfficeCollection;
	}

	public void setMovieBoxOfficeCollection(long movieBoxOfficeCollection) {
		this.movieBoxOfficeCollection = movieBoxOfficeCollection;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre
				+ ", movieDirector=" + movieDirector + ", movieBoxOfficeCollection=" + movieBoxOfficeCollection + "]";
	}

}
