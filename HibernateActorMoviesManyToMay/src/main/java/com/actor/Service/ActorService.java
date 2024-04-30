package com.actor.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.actor.entity.Actor;
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

	public void updateAllActorsAddressBetweenAge() {
//	 (35 - 65)
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		transaction.commit();
		entityManager.close();
	}

	public void findAllActorsByMovieName(String movieName) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> query = criteriaBuilder.createQuery(Actor.class);
		Root<Actor> root = query.from(Actor.class);
//		query.select(root).where(criteriaBuilder.equal(root.get("movies"), criteriaBuilder.equal));

		Query query2 = entityManager.createQuery(query);
		List<Actor> resultList = query2.getResultList();
		resultList.forEach(System.out::println);

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
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Actor> criteriaDelete = criteriaBuilder.createCriteriaDelete(Actor.class);
		Root<Actor> root = criteriaDelete.from(Actor.class);
		criteriaDelete.where(criteriaBuilder.equal(root.get("genre"), genre));

		Query query = entityManager.createQuery(criteriaDelete);
		int result = query.executeUpdate();
		if (result != 0)
			System.out.println(result+" Actors is deleted where genre : " + genre);
		else
			System.out.println("Actor genre : " + genre + " is not present in database");

		transaction.commit();
		entityManager.close();
	}
}
