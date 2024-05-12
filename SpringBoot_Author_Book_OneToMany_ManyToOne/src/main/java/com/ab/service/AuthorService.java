package com.ab.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.ab.entity.Author;
import com.ab.utill.ResponseStructure;

public interface AuthorService {
	ResponseEntity<ResponseStructure<Author>> addAuthor(Author author);

	ResponseEntity<ResponseStructure<Author>> findAuthorById(int authorId);

	ResponseEntity<ResponseStructure<List<Author>>> findAuthorByName(String authorName);

	ResponseEntity<ResponseStructure<List<Author>>> findAuthorBetweenAge(int authorAge1, int authorAge2);

	ResponseEntity<ResponseStructure<List<Author>>> findAllAuthors();

	ResponseEntity<ResponseStructure<Author>> updateAuthorById(int authorId, Author author);

	ResponseEntity<ResponseStructure<Author>> deleteAuthorById(int authodId);

	ResponseEntity<ResponseStructure<List<Author>>> deleteAllAuthorByNationality(String nationality);

	void findAuthorByBookId();

}