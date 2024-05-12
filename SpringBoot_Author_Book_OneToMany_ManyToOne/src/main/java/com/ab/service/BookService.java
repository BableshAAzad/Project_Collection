package com.ab.service;

import org.springframework.http.ResponseEntity;

import com.ab.entity.Book;
import com.ab.utill.ResponseStructure;

public interface BookService {
	ResponseEntity<ResponseStructure<Book>> addBook(Book book, int authorId);

	void findBookById();

	void findBookByName();

	void findBookBetweenPrice();

	void findAllBooksByLanguage();

	void findAllBookByAuthorId();

	void updateBookById();

	void deleteBookByName();

	void deleteAllBookByGenre();

	void deleteAllBookByAuthorId();

}
