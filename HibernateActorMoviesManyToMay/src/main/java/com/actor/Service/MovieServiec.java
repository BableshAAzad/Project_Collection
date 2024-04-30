package com.actor.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.actor.entity.Actor;
import com.actor.entity.Movie;
import com.actor.util.EntityManagerProvider;

public class MovieServiec {

	public void addMovie(Movie movie) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Movie movie2 = entityManager.find(Movie.class, movie.getMovieId());
		if (movie2 == null) {
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
		query.select(root).where(criteriaBuilder.between(root.get("boxOfficeCollection"), boxOfficeCollection1, boxOfficeCollection2));

		Query query2 = entityManager.createQuery(query);
		List<Movie> resultList = query2.getResultList();
		resultList.forEach(System.out::println);

		transaction.commit();
		entityManager.close();
	}

	public void updateBoxOfficeVerdictByBoxOfficeCollection() {
//	   (Block buster -> where collection) 5000000 
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		transaction.commit();
		entityManager.close();
	}

	public void findAllMoviesByActorName(String director) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> query = criteriaBuilder.createQuery(Movie.class);
		Root<Movie> root = query.from(Movie.class);
		query.select(root).where(criteriaBuilder.equal(root.get("director"), director));

		Query query2 = entityManager.createQuery(query);
		List<Movie> resultList = query2.getResultList();
		resultList.forEach(System.out::println);

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
			System.out.println(result + " Movies is deleted where director : " + director);
		else
			System.out.println("Movie director : " + director + " is not present in database");

		transaction.commit();
		entityManager.close();
	}

	public void deleteAllMoviesByActorIndustry() {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		transaction.commit();
		entityManager.close();
	}

}
