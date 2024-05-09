package com.ab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
