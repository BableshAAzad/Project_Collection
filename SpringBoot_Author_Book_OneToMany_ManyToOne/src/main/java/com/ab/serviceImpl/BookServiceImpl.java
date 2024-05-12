package com.ab.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ab.entity.Author;
import com.ab.entity.Book;
import com.ab.exception.AuthorNotFoundException;
import com.ab.repository.AuthorRepository;
import com.ab.repository.BookRepository;
import com.ab.service.BookService;
import com.ab.utill.ResponseStructure;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public ResponseEntity<ResponseStructure<Book>> addBook(Book book, int authorId) {
		Optional<Author> optionalAuthor = authorRepository.findById(authorId);
		if (optionalAuthor.isPresent()) {
			Author author = optionalAuthor.get();
			book.setAuthor(author);
			Book savedBook = bookRepository.save(book);
			ResponseStructure<Book> responseStructure = new ResponseStructure<Book>();
			responseStructure.setMessage("Book is Added");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(savedBook);
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new AuthorNotFoundException("AuthorId : " + authorId + ", is not present in database");
		}
	}

	@Override
	public void findBookById() {
		// TODO Auto-generated method stub

	}

	@Override
	public void findBookByName() {
		// TODO Auto-generated method stub

	}

	@Override
	public void findBookBetweenPrice() {
		// TODO Auto-generated method stub

	}

	@Override
	public void findAllBooksByLanguage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void findAllBookByAuthorId() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBookById() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBookByName() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllBookByGenre() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllBookByAuthorId() {
		// TODO Auto-generated method stub

	}

}
