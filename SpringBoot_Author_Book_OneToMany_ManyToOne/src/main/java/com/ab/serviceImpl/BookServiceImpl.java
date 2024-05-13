package com.ab.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ab.entity.Author;
import com.ab.entity.Book;
import com.ab.exception.AuthorNotFoundException;
import com.ab.exception.BookAlreadyExistException;
import com.ab.exception.BookNotFoundException;
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
			Optional<Book> optionalBook = bookRepository.findById(book.getBookId());
			if (optionalBook.isEmpty()) {
				Author author = optionalAuthor.get();
				book.setAuthor(author);
				Book savedBook = bookRepository.save(book);
				ResponseStructure<Book> responseStructure = new ResponseStructure<Book>();
				responseStructure.setMessage("Book is Added");
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setData(savedBook);
				return new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.CREATED);
			} else {
				throw new BookAlreadyExistException("BookId : " + book.getBookId() + ", is allready exist");
			}
		} else {
			throw new AuthorNotFoundException("AuthorId : " + authorId + ", is not present in database");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Book>> findBookById(int bookId) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (optionalBook.isPresent()) {
			Book book = optionalBook.get();
			ResponseStructure<Book> responseStructure = new ResponseStructure<Book>();
			responseStructure.setMessage("Book fonded");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(book);
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BookNotFoundException("Id : " + bookId + ", is not present in database");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Book>>> findBookByName(String bookName) {
		List<Book> bookList = bookRepository.findBooksByBookName(bookName);
		if (bookList.size() != 0) {
			ResponseStructure<List<Book>> responseStructure = new ResponseStructure<List<Book>>();
			responseStructure.setMessage("Book founded");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(bookList);
			return new ResponseEntity<ResponseStructure<List<Book>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BookNotFoundException("BookName : " + bookName + ", is not present in database");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Book>>> findBookBetweenPrice(int bookPrice1, int bookPrice2) {
		List<Book> bookList = bookRepository.findByBookPriceBetween(bookPrice1, bookPrice2);
		if (bookList.size() != 0) {
			ResponseStructure<List<Book>> responseStructure = new ResponseStructure<List<Book>>();
			responseStructure.setMessage("Book founded");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(bookList);
			return new ResponseEntity<ResponseStructure<List<Book>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BookNotFoundException("No any book present between bookPrice1 : " + bookPrice1
					+ ", and BookPrice2 :" + bookPrice2 + ", in database");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Book>>> findAllBooksByLanguage(String language) {
		List<Book> bookList = bookRepository.findBooksByLanguage(language);
		if (bookList.size() != 0) {
			ResponseStructure<List<Book>> responseStructure = new ResponseStructure<List<Book>>();
			responseStructure.setMessage("Book founded");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(bookList);
			return new ResponseEntity<ResponseStructure<List<Book>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BookNotFoundException("Not found any book by : " + language + " language");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Book>>> findAllBooksByAuthorId(int authorId) {
		Optional<Author> optionalAuthor = authorRepository.findById(authorId);
		if (optionalAuthor.isPresent()) {
			Author author = optionalAuthor.get();
			List<Book> books = author.getBooks();
			ResponseStructure<List<Book>> responseStructure = new ResponseStructure<List<Book>>();
			responseStructure.setMessage("Book founded");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(books);
			return new ResponseEntity<ResponseStructure<List<Book>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AuthorNotFoundException("AuthorId : " + authorId + ", is not present in database");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Book>> updateBookById(int bookId, Book book) {
		Optional<Book> bookOptional = bookRepository.findById(bookId);
		if (bookOptional.isPresent()) {
			Book existingBook = bookOptional.get();
			book.setAuthor(existingBook.getAuthor());
			book.setBookId(bookId);
			Book updateBook = bookRepository.save(book);
			ResponseStructure<Book> responseStructure = new ResponseStructure<Book>();
			responseStructure.setMessage("Book Updated successfully done");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(updateBook);
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BookNotFoundException("Id : " + bookId + ", is not present in database");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Book>>> deleteBookByName(String bookName) {
		List<Book> existingBooks = bookRepository.findBooksByBookName(bookName);
		if (existingBooks.size() != 0) {
			bookRepository.deleteAll(existingBooks);
			ResponseStructure<List<Book>> responseStructure = new ResponseStructure<List<Book>>();
			responseStructure.setMessage(existingBooks.size() + ", Books are deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(existingBooks);
			return new ResponseEntity<ResponseStructure<List<Book>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BookNotFoundException("BookName : '" + bookName + "', is not present in database");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Book>>> deleteAllBookByGenre(String genre) {
		List<Book> deleteBooksList = bookRepository.deleteBooksByGenre(genre);
		if (deleteBooksList.size() != 0) {
			ResponseStructure<List<Book>> responseStructure = new ResponseStructure<List<Book>>();
			responseStructure.setMessage(deleteBooksList.size() + ", Books are deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(deleteBooksList);
			return new ResponseEntity<ResponseStructure<List<Book>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BookNotFoundException("Genre : " + genre + ", this category not present any book");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Book>>> deleteAllBooksByAuthorId(int authorId) {
		Optional<Author> optionalAuthor = authorRepository.findById(authorId);
		if (optionalAuthor.isPresent()) {
			Author author = optionalAuthor.get();
			List<Book> existingBooks = author.getBooks();
			if (existingBooks.size() != 0) {
//				author.setBooks(null);
//				authorRepository.save(author);
				bookRepository.deleteAll(existingBooks);
				ResponseStructure<List<Book>> responseStructure = new ResponseStructure<List<Book>>();
				responseStructure.setMessage(existingBooks.size() + ", Books are deleted");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(existingBooks);
				return new ResponseEntity<ResponseStructure<List<Book>>>(responseStructure, HttpStatus.OK);
			} else {
				throw new BookNotFoundException("Not present of any Book AuthorName : " + author.getAuthorName());
			}
		} else {
			throw new AuthorNotFoundException("AuthorId : " + authorId + ", not found in database");
		}
	}
}
