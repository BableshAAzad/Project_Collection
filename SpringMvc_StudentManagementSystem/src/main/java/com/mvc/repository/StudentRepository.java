package com.mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mvc.entity.Student;

@Repository
public class StudentRepository {
	public static EntityManager getEntityManager() {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentdb");
		  EntityManager em = emf.createEntityManager();
		  return em;
	  }
	
  public void addStudent(Student s) {
	  EntityManager em = StudentRepository.getEntityManager();
	  EntityTransaction etx = em.getTransaction();
	  etx.begin();
	  
	  em.persist(s);
	  
	  etx.commit();
	  em.close();
  }
  
  public List<Student> displayAllStudent(){
	  EntityManager em = StudentRepository.getEntityManager();
	  EntityTransaction etx = em.getTransaction();
	  etx.begin();
	  
	  Query q = em.createQuery("from Student");
	  List<Student> list = q.getResultList();
	  
	  etx.commit();
	  em.close();
	  return list;
  }
  
  public Student getStudentData(int studentId) {
	  EntityManager em = StudentRepository.getEntityManager();
	  EntityTransaction etx = em.getTransaction();
	  etx.begin();
	  Student s = em.find(Student.class, studentId);
	  etx.commit();
	  em.close();
	  return s;
  }
  
  public void updateStudent(int studentId, String studentName, String studentEmail, String studentPassword) {
	  EntityManager em = StudentRepository.getEntityManager();
	  EntityTransaction etx = em.getTransaction();
	  etx.begin();
	  
	  Student s = em.find(Student.class, studentId);
	  s.setStudentName(studentName);
	  s.setStudentEmail(studentEmail);
	  s.setStudentPassword(studentPassword);
	  em.persist(s);
	  
	  etx.commit();
	  em.close();
  }
  
  public void deleteStudent(int studentId) {
	  EntityManager em = StudentRepository.getEntityManager();
	  EntityTransaction etx = em.getTransaction();
	  etx.begin();
	  Student s = em.find(Student.class, studentId);
	  em.remove(s);
	  
	  etx.commit();
	  em.close();
  }
}
