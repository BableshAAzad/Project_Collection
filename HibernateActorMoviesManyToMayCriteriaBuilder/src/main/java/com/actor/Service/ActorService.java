package com.actor.Service;

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

public class ActorService {

	public void addActor(Actor actor) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Actor actor2 = entityManager.find(Actor.class, actor.getActorId());
		if (actor2 == null) {
			entityManager.persist(actor);
			System.out.println("Actor Added Successfully.....>>>!!!<<<<");
		} else {
			System.out.println("Actor Id : " + actor.getActorId() + " is already exist");
		}

		transaction.commit();
		entityManager.close();
	}

	public void findActorById(int actorId) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> query = criteriaBuilder.createQuery(Actor.class);
		Root<Actor> root = query.from(Actor.class);
		query.select(root).where(criteriaBuilder.equal(root.get("actorId"), actorId));

		Query query2 = entityManager.createQuery(query);
		Actor actor = (Actor) query2.getSingleResult();
		if (actor != null)
			System.out.println(actor);
		else
			System.out.println("Actor Id : " + actorId + " is not present in data");
		transaction.commit();
		entityManager.close();
	}

	public void findActorByName(String actorName) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> query = criteriaBuilder.createQuery(Actor.class);
		Root<Actor> root = query.from(Actor.class);
		query.select(root).where(criteriaBuilder.equal(root.get("actorName"), actorName));

		Query query2 = entityManager.createQuery(query);
		List<Actor> resultList = query2.getResultList();
		resultList.forEach(System.out::println);

		transaction.commit();
		entityManager.close();
	}

	public void findAllActorByIndustry(String industry) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> query = criteriaBuilder.createQuery(Actor.class);
		Root<Actor> root = query.from(Actor.class);
		query.select(root).where(criteriaBuilder.equal(root.get("industry"), industry));

		Query query2 = entityManager.createQuery(query);
		List<Actor> resultList = query2.getResultList();
		resultList.forEach(System.out::println);

		transaction.commit();
		entityManager.close();
	}

	public void updateAllActorsAddressBetweenAge(int actorAge1, int actorAge2, String actorAddress) {
//	 (35 - 65)
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Actor> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Actor.class);
		Root<Actor> root = criteriaUpdate.from(Actor.class);
		criteriaUpdate.set("actorAddress", actorAddress);
		criteriaUpdate.where(criteriaBuilder.between(root.get("actorAge"), actorAge1, actorAge2));

		Query query2 = entityManager.createQuery(criteriaUpdate);
		int result1 = query2.executeUpdate();
		System.out.println(result1 + " : record is updated");
		transaction.commit();
		entityManager.close();
	}

	public void findAllActorsByMovieName(String movieName) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("from Movie m where m.movieName = :mName");
		query.setParameter("mName", movieName);
		Movie movie = (Movie) query.getSingleResult();
		if (movie != null) {
			List<Actor> actors = movie.getActors();
			System.out.println("Total : " + actors.size() + " actors are working on movieName : " + movieName);
			if (actors.size() != 0) {
				for (Actor a : actors) {
					System.out.println("ActorName : " + a.getActorName() + ", ActorId : " + a.getActorId()
							+ ", MovieName : " + movie.getMovieName());
				}
			} else {
				System.out.println("No Actors present on this moveis : " + movieName);
			}
		} else {
			System.out.println("This movie name is not present in database : " + movieName);
		}

		transaction.commit();
		entityManager.close();
	}

	public void deleteActorById(int actorId) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Actor> criteriaDelete = criteriaBuilder.createCriteriaDelete(Actor.class);
		Root<Actor> root = criteriaDelete.from(Actor.class);
		criteriaDelete.where(criteriaBuilder.equal(root.get("actorId"), actorId));

		Query query = entityManager.createQuery(criteriaDelete);
		int result = query.executeUpdate();
		if (result != 0)
			System.out.println("Actor is deleted id : " + actorId);
		else
			System.out.println("Actor id : " + actorId + " is not present in database");

		transaction.commit();
		entityManager.close();
	}

	public void deleteAllActorsByNationality(String nationality) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Actor> criteriaDelete = criteriaBuilder.createCriteriaDelete(Actor.class);
		Root<Actor> root = criteriaDelete.from(Actor.class);
		criteriaDelete.where(criteriaBuilder.equal(root.get("nationality"), nationality));

		Query query = entityManager.createQuery(criteriaDelete);
		int result = query.executeUpdate();
		if (result != 0)
			System.out.println(result + " Actors is deleted where nationality : " + nationality);
		else
			System.out.println("Actor nationality : " + nationality + " is not present in database");

		transaction.commit();
		entityManager.close();
	}

	public void deleteAllActorsByMovieGenre(String genre) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("from Movie m where m.genre = : mGenre");
		query.setParameter("mGenre", genre);
		List<Movie> movies = query.getResultList();
		if (movies.size() != 0) {
			System.out.println("Total : " + movies.size() + " Movies are present of this genre : " + genre);
			for (Movie m : movies) {
				System.out.println("MovieName : " + m.getMovieName() + ", MovieId : " + m.getMovieId());
			}
			for (Movie m : movies) {
				List<Actor> actors = m.getActors();
				for (Actor a : actors) {
					System.out.println(
							"ActorId : " + a.getActorId() + ", ActorName : " + a.getActorName() + " is deleted");
					entityManager.remove(a);
				}
				m.setActors(null);
				entityManager.merge(m);
			}
		} else {
			System.out.println("Not present any movie of this genre : " + genre);
		}

		transaction.commit();
		entityManager.close();
	}

//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void getAllActors() {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("from Actor");
		List<Actor> resultList = query.getResultList();
//		resultList.forEach(System.out::println);
		System.out.println("Total : "+resultList.size()+", Actors Present In Database");
		for (Actor a : resultList) {
			System.out.println("Actor Id : " + a.getActorId() + ", Actor Name : " + a.getActorName());
		}
		transaction.commit();
		entityManager.close();
	}

}
