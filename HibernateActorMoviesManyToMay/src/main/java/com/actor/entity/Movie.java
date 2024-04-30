package com.actor.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
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
}
