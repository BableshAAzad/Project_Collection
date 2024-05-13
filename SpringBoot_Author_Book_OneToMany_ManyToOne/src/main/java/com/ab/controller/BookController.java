package com.ab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/findBookById/{bookId}")
	public ResponseEntity<ResponseStructure<Book>> findBookById(@PathVariable int bookId) {
		return bookService.findBookById(bookId);
	}
	
	@GetMapping("/findBookByName/{bookName}")
	public ResponseEntity<ResponseStructure<List<Book>>> findBookByName(@PathVariable String bookName) {
		return bookService.findBookByName(bookName);
	}
	
	@GetMapping("/findBookBetweenPrice")
	public ResponseEntity<ResponseStructure<List<Book>>> findBookBetweenPrice(@RequestParam int bookPrice1, @RequestParam int bookPrice2){
		return bookService.findBookBetweenPrice(bookPrice1, bookPrice2);
	}
	
	@GetMapping("/findAllBooksByLanguage/{language}")
	public ResponseEntity<ResponseStructure<List<Book>>> findAllBooksByLanguage(@PathVariable String language){
		return bookService.findAllBooksByLanguage(language);
	}
	
	@GetMapping("findAllBooksByAuthorId/{authorId}")
	public ResponseEntity<ResponseStructure<List<Book>>> findAllBooksByAuthorId(@PathVariable int authorId) {
		return bookService.findAllBooksByAuthorId(authorId);
	}
	
	@PutMapping("/updateBookById/{bookId}")
	public ResponseEntity<ResponseStructure<Book>> updateBookById(@PathVariable int bookId, @RequestBody Book book) {
		return bookService.updateBookById(bookId, book);
	}
	
	@DeleteMapping("/deleteBookByName/{bookName}")
	public ResponseEntity<ResponseStructure<List<Book>>> deleteBookByName(@PathVariable String bookName) {
		return bookService.deleteBookByName(bookName);
	}
	
	@DeleteMapping("/deleteBookByGenre/{genre}")
	public ResponseEntity<ResponseStructure<List<Book>>> deleteAllBookByGenre(@PathVariable String genre){
		return bookService.deleteAllBookByGenre(genre);
	}
	
	@DeleteMapping("/deleteAllBooksByAuthorId/{authorId}")
	public ResponseEntity<ResponseStructure<List<Book>>> deleteAllBooksByAuthorId(@PathVariable int authorId) {
		return bookService.deleteAllBooksByAuthorId(authorId);
	}

}
