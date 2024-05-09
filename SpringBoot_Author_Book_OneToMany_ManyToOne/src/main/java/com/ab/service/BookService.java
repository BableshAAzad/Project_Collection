package com.ab.service;

public interface BookService {
	void addBook();

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
