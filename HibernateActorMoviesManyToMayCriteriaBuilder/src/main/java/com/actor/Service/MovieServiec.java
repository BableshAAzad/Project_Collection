package com.actor.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import com.actor.entity.Actor;
import com.actor.entity.Movie;
import com.actor.util.EntityManagerProvider;

public class MovieServiec {

	public void addMovie(Movie movie, String actorIds) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Movie movie2 = entityManager.find(Movie.class, movie.getMovieId());
		Actor actorX = null;
		List<Actor> list = new ArrayList<>();
		if (movie2 == null) {
			String[] actorIdStr = actorIds.split(",");
			for (String s : actorIdStr) {
				int actorIdNew = Integer.parseInt(s);
				 actorX = entityManager.find(Actor.class, actorIdNew);
				if (actorX != null) {
					list.add(actorX);
				}
			}
			movie.setActors(list);
			entityManager.persist(movie);
			System.out.println("Movie Added Successfully.....>>>!!!<<<<");
		} else {
			System.out.println("Movie Id : " + movie.getMovieId() + " is already exist");
		}
		transaction.commit();
		entityManager.close();
	}

	public void findMovieById(int movieId) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> query = criteriaBuilder.createQuery(Movie.class);
		Root<Movie> root = query.from(Movie.class);
		query.select(root).where(criteriaBuilder.equal(root.get("movieId"), movieId));

		Query query2 = entityManager.createQuery(query);
		Movie movie = (Movie) query2.getSingleResult();
		if (movie != null)
			System.out.println(movie);
		else
			System.out.println("Movie Id : " + movieId + " is not present in data");

		transaction.commit();
		entityManager.close();
	}

	public void findAllMoviesByLanguage(String language) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> query = criteriaBuilder.createQuery(Movie.class);
		Root<Movie> root = query.from(Movie.class);
		query.select(root).where(criteriaBuilder.equal(root.get("language"), language));

		Query query2 = entityManager.createQuery(query);
		List<Movie> resultList = query2.getResultList();
		resultList.forEach(System.out::println);

		transaction.commit();
		entityManager.close();
	}

	public void findAllMoviesBetweenBoxOfficeCollection(int boxOfficeCollection1, int boxOfficeCollection2) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> query = criteriaBuilder.createQuery(Movie.class);
		Root<Movie> root = query.from(Movie.class);
		query.select(root).where(
				criteriaBuilder.between(root.get("boxOfficeCollection"), boxOfficeCollection1, boxOfficeCollection2));

		Query query2 = entityManager.createQuery(query);
		List<Movie> resultList = query2.getResultList();
		resultList.forEach(System.out::println);

		transaction.commit();
		entityManager.close();
	}

	public void updateBoxOfficeVerdictByBoxOfficeCollection(int boxOfficeCollection, String boxOfficeVerdict) {
//	   (Block buster -> where collection) 5000000 
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Movie> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Movie.class);
		Root<Movie> root = criteriaUpdate.from(Movie.class);
		criteriaUpdate.set("boxOfficeVerdict", boxOfficeVerdict);
		criteriaUpdate.where(criteriaBuilder.gt(root.get("boxOfficeCollection"), boxOfficeCollection));

		Query query = entityManager.createQuery(criteriaUpdate);
		int result = query.executeUpdate();
		System.out.println(result + " : records is updated");

		transaction.commit();
		entityManager.close();
	}

	public void findAllMoviesByActorName(String actorName) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> query = criteriaBuilder.createQuery(Actor.class);
		Root<Actor> root = query.from(Actor.class);
		query.select(root).where(criteriaBuilder.equal(root.get("actorName"), actorName));

		Query query2 = entityManager.createQuery(query);
		Actor actor = (Actor) query2.getSingleResult();
		if (actor != null) {
			List<Movie> movies = actor.getMovies();
			System.out.println("ActorName : " + actor.getActorName() + " Make total Movies : " + movies.size());
			for (Movie m : movies) {
				System.out.println("MovieName : " + m.getMovieName() + ", MovieId : " + m.getMovieId()
						+ ", ActorName : " + actor.getActorName());
			}
		} else {
			System.out.println(actorName + " this actor not make any movies");
		}

		transaction.commit();
		entityManager.close();
	}

	public void deleteAllMoviesByDirector(String director) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Movie> criteriaDelete = criteriaBuilder.createCriteriaDelete(Movie.class);
		Root<Movie> root = criteriaDelete.from(Movie.class);
		criteriaDelete.where(criteriaBuilder.equal(root.get("director"), director));

		Query query = entityManager.createQuery(criteriaDelete);
		int result = query.executeUpdate();
		if (result != 0)
			System.out.println(result + " Movies is deleted where Director Name : " + director);
		else
			System.out.println("Movie director : " + director + " is not present in database");

		transaction.commit();
		entityManager.close();
	}

	public void deleteAllMoviesByActorIndustry(String industry) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> query = criteriaBuilder.createQuery(Actor.class);
		Root<Actor> root = query.from(Actor.class);
		query.select(root).where(criteriaBuilder.equal(root.get("industry"), industry));

		Query query2 = entityManager.createQuery(query);
		Actor actor = (Actor) query2.getSingleResult();
		if (actor != null) {
			List<Movie> movies = actor.getMovies();
			System.out.println("Intdustry : " + industry + " total movies present : " + movies.size());
			for (Movie m : movies) {
				entityManager.remove(m);
			}
		} else {
			System.out.println(industry + " on this industry no present any actor");
		}

		transaction.commit();
		entityManager.close();
	}

//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void getAllMovies() {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("from Movie");
		List<Movie> resultList = query.getResultList();
//		resultList.forEach(System.out::println);
		System.out.println("Total : "+resultList.size()+", Movies Present In Database");
		for (Movie m : resultList) {
			System.out.println("Movie Id : " + m.getMovieId() + ", Movie Name : " + m.getMovieName());
		}
		transaction.commit();
		entityManager.close();
	}

}
