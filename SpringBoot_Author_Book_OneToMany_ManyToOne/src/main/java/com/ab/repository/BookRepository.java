package com.ab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ab.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> findBooksByBookName(String bookName);
	
	List<Book> findByBookPriceBetween(int bookPrice1, int bookPrice2);
	
//	-------------------------------------------------------------------------
//	@Query("from Book b where b.language = :blang")
//	List<Book> findBooksByLanguage(@Param("blang") String language);
//	or
//	List<Book> findBooksByLanguage(String language);
//	or
	@Query("from Book b where b.language = ?1")
	List<Book> findBooksByLanguage(String language);
//	-------------------------------------------------------------------------
	
	@Transactional
	List<Book> deleteBooksByGenre(String genre);
	
}