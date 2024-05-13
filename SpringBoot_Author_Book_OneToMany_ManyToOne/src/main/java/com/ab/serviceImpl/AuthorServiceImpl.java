package com.ab.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ab.entity.Author;
import com.ab.entity.Book;
import com.ab.exception.AuthorAreadyExistException;
import com.ab.exception.AuthorNotFoundException;
import com.ab.exception.BookNotFoundException;
import com.ab.repository.AuthorRepository;
import com.ab.repository.BookRepository;
import com.ab.service.AuthorService;
import com.ab.utill.ResponseStructure;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public ResponseEntity<ResponseStructure<Author>> addAuthor(Author author) {
		Optional<Author> existingAuthor = authorRepository.findById(author.getAuthorId());
		if(existingAuthor.isEmpty()) {
		ResponseStructure<Author> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Author is added");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());

		Author savedAuthor = authorRepository.save(author);
		responseStructure.setData(savedAuthor);
		return new ResponseEntity<ResponseStructure<Author>>(responseStructure, HttpStatus.CREATED);
		}else {
			throw new AuthorAreadyExistException("Id : " + author.getAuthorId() + ", is already exists");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Author>> findAuthorById(int authorId) {
		Optional<Author> option = authorRepository.findById(authorId);
		if (option.isPresent()) {
			Author author = option.get();
			ResponseStructure<Author> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Author finded");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(author);
			return new ResponseEntity<ResponseStructure<Author>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AuthorNotFoundException("Id : " + authorId + ", not found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Author>>> findAuthorByName(String authorName) {
		List<Author> authors = authorRepository.findAuthorByName(authorName);
		if (authors.size() != 0) {
			ResponseStructure<List<Author>> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Author finded");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(authors);
			return new ResponseEntity<ResponseStructure<List<Author>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AuthorNotFoundException("AuthorName : " + authorName + ", Not Found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Author>>> findAuthorBetweenAge(int authorAge1, int authorAge2) {
		List<Author> authors = authorRepository.findByAuthorAgeBetween(authorAge1, authorAge2);
		if (authors.size() != 0) {
			ResponseStructure<List<Author>> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Author finded");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(authors);
			return new ResponseEntity<ResponseStructure<List<Author>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AuthorNotFoundException(
					"AuthorAge1 : " + authorAge1 + ", And AuthorAge2 : " + authorAge2 + ", not any author present");
		}

	}

	@Override
	public ResponseEntity<ResponseStructure<List<Author>>> findAllAuthors() {
		List<Author> authors = authorRepository.findAll();
		if (authors.size() != 0) {
			ResponseStructure<List<Author>> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Author finded");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(authors);
			return new ResponseEntity<ResponseStructure<List<Author>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AuthorNotFoundException("No author present there....!!!");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Author>> updateAuthorById(int authorId, Author author) {
		ResponseStructure<Author> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Author updated successfully done....!!!");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		Optional<Author> option = authorRepository.findById(authorId);
		if (option.isPresent()) {
			Author existingAuthor = option.get();
			author.setAuthorId(existingAuthor.getAuthorId());
			Author updatedAuthor = authorRepository.save(author);
			responseStructure.setData(updatedAuthor);
			return new ResponseEntity<ResponseStructure<Author>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AuthorNotFoundException("Id : " + authorId + ", not found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Author>> deleteAuthorById(int authorId) {

		Optional<Author> option = authorRepository.findById(authorId);
		if (option.isPresent()) {
			Author author = option.get();

			ResponseStructure<Author> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Author Deleted successfully");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(author);

			authorRepository.delete(author);
			return new ResponseEntity<ResponseStructure<Author>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AuthorNotFoundException("Id : " + authorId + ", not found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Author>>> deleteAllAuthorByNationality(String nationality) {
		List<Author> deletedAuthors = authorRepository.deleteAuthorsByNationality(nationality);
		if (deletedAuthors.size() != 0) {
			ResponseStructure<List<Author>> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage(deletedAuthors.size() + ", Authors deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(deletedAuthors);
			return new ResponseEntity<ResponseStructure<List<Author>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AuthorNotFoundException("Nationality : " + nationality + ", not found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Author>> findAuthorByBookId(int bookId) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (optionalBook.isPresent()) {
			Book existingBook = optionalBook.get();
			Author author = existingBook.getAuthor();
			ResponseStructure<Author> responseStructure = new ResponseStructure<Author>();
			responseStructure.setMessage("Author is present");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(author);
			return new ResponseEntity<ResponseStructure<Author>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BookNotFoundException(bookId + ", is not present in database");
		}
	}

}
