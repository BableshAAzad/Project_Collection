package com.ipl.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ipl.entity.Player;

@Repository
public class PlayerRepository {
	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demoJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

// inbuit method
	public void addPlayer(int playerid, String playerName, int playerAge, String playerContry, String iplTeam,
			long iplSalary) {
		Player player = new Player();
		player.setPlayerId(playerid);
		player.setPlayerName(playerName);
		player.setPlayerAge(playerAge);
		player.setPlayerContry(playerContry);
		player.setIplTeam(iplTeam);
		player.setIplSalary(iplSalary);

		EntityManager entityManager = PlayerRepository.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(player);

		entityTransaction.commit();
		entityManager.close();
	}

// criteria api
	public Player findPlayerById(int playerId) {
		EntityManager entityManager = PlayerRepository.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> root = cq.from(Player.class);
		cq.select(root);
		cq.where(cb.equal(root.get("playerId"), playerId));

		Query query = entityManager.createQuery(cq);
		Player player = (Player) query.getSingleResult();

		entityTransaction.commit();
		entityManager.close();
		return player;
	}

//	   using query interface
	public Player findPlayerByName(String playerName) {
		EntityManager entityManager = PlayerRepository.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Query query = entityManager.createQuery("select p from Player p where p.playerName=:pname");
		query.setParameter("pname", playerName);
		Player player = (Player) query.getSingleResult();

		entityTransaction.commit();
		entityManager.close();
		return player;
	}

//       native query interface
	public List<Player> findAllPlayerByContry(String playerContry) {
		EntityManager entityManager = PlayerRepository.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Query query = entityManager.createNativeQuery("select * from player where playerContry=?", Player.class);
		query.setParameter(1, playerContry);
		List<Player> players = query.getResultList();

		entityTransaction.commit();
		entityManager.close();
		return players;
	}

//		   criteria api
	public List<Player> findAllPlayerByIplTeam(String iplTeam) {
		EntityManager entityManager = PlayerRepository.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Player> createQuery = criteriaBuilder.createQuery(Player.class);
		Root<Player> root = createQuery.from(Player.class);
		createQuery.select(root);
		createQuery.where(criteriaBuilder.equal(root.get("iplTeam"), iplTeam));

		Query query = entityManager.createQuery(createQuery);
		List<Player> resultList = query.getResultList();

		entityTransaction.commit();
		entityManager.close();
		return resultList;
	}

//		   inbuilt method
	public String updatePlayerAgeByPlayerId(int playerId, int playerAge) {
		EntityManager entityManager = PlayerRepository.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Player player = entityManager.find(Player.class, playerId);
		if (player != null) {
			player.setPlayerAge(playerAge);
			entityManager.merge(player);
			entityTransaction.commit();
			entityManager.close();
			return "updated";
		} else {
			return "ID not match in database";
		}
	}

//		   criteria update (current salary + 200000)
	public int updateAllPlayerSalaryByIplTeam(String iplTeam) {
		int res = 0;
		EntityManager entityManager = PlayerRepository.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

//		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//		CriteriaUpdate<Player> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Player.class);
//		Root<Player> root = criteriaUpdate.from(Player.class);
//
//		Expression<Long> sumExpression = criteriaBuilder.sum(root.get("iplSalary"), 200000l);
//		criteriaUpdate.set(root.get("iplSalary"), sumExpression);
//		criteriaUpdate.where(criteriaBuilder.equal(root.get("iplTeam"), iplTeam));
//
//		Query query = entityManager.createQuery(criteriaUpdate);
//		res = query.executeUpdate();
//	---------------------------------------------------------------
		Query nativeQuery = entityManager
				.createNativeQuery("update player p set p.iplSalary = p.iplSalary + ? where p.iplTeam =?");
		nativeQuery.setParameter(1, 200000);
		nativeQuery.setParameter(2, iplTeam);
		res = nativeQuery.executeUpdate();
//		-------------------------------------------------------------
//		Query query = entityManager
//				.createQuery("update Player p set p.iplSalary = p.iplSalary + ?1 where p.iplTeam = ?2");
//		query.setParameter(1, 7777l);
//		query.setParameter(2, iplTeam);
//		res = query.executeUpdate();
//		-------------------------------------------------------------
		transaction.commit();
		entityManager.close();
		return res;
	}

//		   Criteria delete
	public int deletePlayerBetweenAge(int age1, int age2) {
		EntityManager entityManager = PlayerRepository.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Player> criteriaDelete = criteriaBuilder.createCriteriaDelete(Player.class);
		Root<Player> root = criteriaDelete.from(Player.class);
		criteriaDelete.where(criteriaBuilder.between(root.get("playerAge"), age1, age2));

		Query query = entityManager.createQuery(criteriaDelete);
		int res = 0;
		res = query.executeUpdate();

		entityTransaction.commit();
		entityManager.close();

		return res;
	}

//		   Query Interface
	public int deleteAllPlayerByCountry(String playerContry) {
		int res = 0;
		EntityManager entityManager = PlayerRepository.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Query query = entityManager.createQuery("delete from Player p where p.playerContry = :pcountry");
		query.setParameter("pcountry", playerContry);
		res = query.executeUpdate();

		entityTransaction.commit();
		entityManager.close();
		return res;
	}
}
