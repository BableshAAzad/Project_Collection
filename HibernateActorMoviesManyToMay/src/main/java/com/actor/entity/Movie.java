package com.actor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie {
	@Id
    private int movieId;
    private String movieName;
    private String language;
    private String director;
    private String genre;
    private int boxOfficeCollection;
    private String boxOfficeVerdict;
    @ManyToMany
    private List<Actor> actors;
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", director="
				+ director + ", genre=" + genre + ", boxOfficeCollection=" + boxOfficeCollection + ", boxOfficeVerdict="
				+ boxOfficeVerdict + "]";
	}
    
}
