package com.ab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.entity.Book;
import com.ab.service.BookService;
import com.ab.utill.ResponseStructure;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook/{authorId}")
	public ResponseEntity<ResponseStructure<Book>> addBook(@RequestBody Book book, @PathVariable int authorId){
		return bookService.addBook(book, authorId);
	}

}
