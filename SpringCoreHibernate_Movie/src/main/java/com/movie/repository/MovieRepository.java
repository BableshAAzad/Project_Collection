package com.movie.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.movie.entity.Movie;

@Repository
public class MovieRepository {

	public static Session getSession() {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Movie.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	public void addMovie(int movieId, String movieName, String movieGenre, String movieDirector,
			long movieBoxOfficeCollection) {
		Movie movie = new Movie();
		movie.setMovieId(movieId);
		movie.setMovieName(movieName);
		movie.setMovieGenre(movieName);
		movie.setMovieDirector(movieDirector);
		movie.setMovieBoxOfficeCollection(movieBoxOfficeCollection);

		Session session = MovieRepository.getSession();
		Transaction tx = session.beginTransaction();
		session.save(movie);
		tx.commit();
		session.close();
	}

	public Movie findMovieById(int movieId) {
		Session session = MovieRepository.getSession();
		Transaction tx = session.beginTransaction();
		Movie movie = session.get(Movie.class, movieId);
		if (movie != null) {
			tx.commit();
			session.close();
			return movie;
		} else {
			return null;
		}
	}

	public String updateMovieById(int movieId, String movieName, String movieGenre, String movieDirector,
			long movieBoxOfficeCollection) {
		Session session = MovieRepository.getSession();
		Transaction tx = session.beginTransaction();
		Movie movie = session.get(Movie.class, movieId);
		if (movie != null) {
			movie.setMovieName(movieName);
			movie.setMovieGenre(movieGenre);
			movie.setMovieDirector(movieDirector);
			movie.setMovieBoxOfficeCollection(movieBoxOfficeCollection);
			session.update(movie);
			tx.commit();
			session.close();
			return "updated";
		} else {
			return "id not available";
		}
	}

	public String deleteMovieById(int movieId) {
		Session session = MovieRepository.getSession();
		Transaction tx = session.beginTransaction();
		Movie movie = session.get(Movie.class, movieId);
		if (movie != null) {
			session.delete(movie);
			tx.commit();
			session.close();
			return "deleted";
		} else {
			return "id not available";
		}
	}

	public Movie findMovieByName(String movieName) {
		Session session = MovieRepository.getSession();
		Transaction tx = session.beginTransaction();
		Query<Movie> query = session.createQuery("from Movie m where m.movieName =:movieN");
		query.setParameter("movieN", movieName);
		Movie movie = (Movie) query.getSingleResult();
		tx.commit();
		session.close();
		return movie;
	}

	public List<Movie> findAllMovies() {
		Session session = MovieRepository.getSession();
		Transaction tx = session.beginTransaction();
		NativeQuery<Movie> nativeQuery = session.createNativeQuery("select * from movie", Movie.class);
		List<Movie> list = nativeQuery.list();
		tx.commit();
		session.close();
		return list;
	}

	public List<Movie> findAllMovesByGenre(String movieGenre) {
		Session session = MovieRepository.getSession();
		Transaction tx = session.beginTransaction();
//		Query<Movie> query = session.createQuery("from Movie m where m.movieGenre =:movieG");
		NativeQuery<Movie> nativeQuery = session.createNativeQuery("select * from movie where movieGenre =?")
				.addEntity(Movie.class);
		nativeQuery.setParameter(1, movieGenre);
		List<Movie> list = nativeQuery.list();
		tx.commit();
		session.close();
		return list;
	}

	public String updateMovieCollectionByName(String movieName, long movieBoxOfficeCollection) {
		Session session = MovieRepository.getSession();
		Transaction tx = session.beginTransaction();
		Query<Movie> query = session.createQuery("select m from Movie m where m.movieName =?3");
		query.setParameter(3, movieName);
		Movie movie = (Movie) query.getSingleResult();
		if (movie != null) {
			movie.setMovieBoxOfficeCollection(movieBoxOfficeCollection);
			session.update(movie);
			tx.commit();
			session.close();
			return "Updated";
		} else {
			return "Movie Not found in database";
		}
	}

	public int deleteAllMovieByDirector(String movieDirector) {
		Session session = MovieRepository.getSession();
		Transaction tx = session.beginTransaction();
		Query<Movie> query = session.createQuery("delete from Movie m where m.movieDirector =:movieD");
		query.setParameter("movieD", movieDirector);
		int res = 0;
		res = query.executeUpdate();
		if (res != 0) {
			tx.commit();
			session.close();
			return res;
		} else {
			return 0;
		}
	}
}
