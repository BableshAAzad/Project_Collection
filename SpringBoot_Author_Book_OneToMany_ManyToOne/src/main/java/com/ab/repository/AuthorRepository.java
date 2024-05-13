package com.ab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ab.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	@Query("select a from Author a where a.authorName = :aname")
	List<Author> findAuthorByName(@Param("aname") String authorName);
//	--------------------------------------------------------------------------------------
//	List<Author> findByAuthorAgeBetween(int authorAge1, int authorAge2);

//	@Query(value="select * from author a where a.author_age between :age1 and :age2", nativeQuery = true)
//	List<Author> findByAuthorAgeBetween(@Param("age1") int authorAge1, @Param("age2") int authorAge2);
	
	@Query("select a from Author a where a.authorAge between :age1 and :age2")
	List<Author> findByAuthorAgeBetween(@Param("age1") int authorAge1, @Param("age2") int authorAge2);
	
//-----------------------------------------------------------------------------------------
//	@Modifying
//	@Query("delete from Author a where a.nationality = ?1")
//	List<Author> deleteAuthorsByNationality(String nationality);
	
//	@Transactional
//	@Query("delete from Author a where a.nationality = :nation")
//	List<Author> deleteAuthorsByNationality(@Param("nation") String nationality);
	
	@Transactional
	List<Author> deleteAuthorsByNationality(String nationality);
//	----------------------------------------------------------------------------------------
	
	
}
