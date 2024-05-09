package com.ab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ab.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	@Query("select a from Author a where a.authorName = :aname")
	List<Author> findAuthorByName(@Param("aname") String authorName);
	
	@Query("select a from Author a where a.authorAge between :age1 and :age2")
	List<Author> findByAuthorAgeBetween(@Param("age1") int authorAge1, @Param("age2") int authorAge2);
}
