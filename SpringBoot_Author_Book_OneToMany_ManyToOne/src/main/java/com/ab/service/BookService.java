package com.ab.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ab.entity.Book;
import com.ab.utill.ResponseStructure;

public interface BookService {
	ResponseEntity<ResponseStructure<Book>> addBook(Book book, int authorId);

	ResponseEntity<ResponseStructure<Book>> findBookById(int bookId);

	ResponseEntity<ResponseStructure<List<Book>>> findBookByName(String bookName);

	ResponseEntity<ResponseStructure<List<Book>>> findBookBetweenPrice(int bookPrice1, int bookPrice2);

	ResponseEntity<ResponseStructure<List<Book>>> findAllBooksByLanguage(String language);

	ResponseEntity<ResponseStructure<List<Book>>> findAllBooksByAuthorId(int authorId);

	ResponseEntity<ResponseStructure<Book>> updateBookById(int bookId, Book book);

	ResponseEntity<ResponseStructure<List<Book>>> deleteBookByName(String bookName);

	ResponseEntity<ResponseStructure<List<Book>>> deleteAllBookByGenre(String genre);

	ResponseEntity<ResponseStructure<List<Book>>> deleteAllBooksByAuthorId(int authorId);

}
