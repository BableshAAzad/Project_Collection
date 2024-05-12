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

import com.ab.entity.Author;
import com.ab.service.AuthorService;
import com.ab.utill.ResponseStructure;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	@PostMapping("/addAuthor")
	public ResponseEntity<ResponseStructure<Author>> addAuthor(@RequestBody Author author) {
		return authorService.addAuthor(author);
	}

	@GetMapping("/findAuthorById/{authorId}")
	public ResponseEntity<ResponseStructure<Author>> findAuthorById(@PathVariable int authorId) {
		return authorService.findAuthorById(authorId);
	}

	@GetMapping("/findAuthorByName/{authorName}")
	public ResponseEntity<ResponseStructure<List<Author>>> findAuthorByName(@PathVariable String authorName) {
		return authorService.findAuthorByName(authorName);
	}

	@GetMapping("/findAuthorBetweenAge")
	public ResponseEntity<ResponseStructure<List<Author>>> findAuthorBetweenAge(@RequestParam int authorAge1,
			@RequestParam int authorAge2) {
		return authorService.findAuthorBetweenAge(authorAge1, authorAge2);
	}

	@GetMapping("/findAllAuthors")
	public ResponseEntity<ResponseStructure<List<Author>>> findAllAuthors() {
		return authorService.findAllAuthors();
	}

	@PutMapping("/updateAuthorById/{authorId}")
	public ResponseEntity<ResponseStructure<Author>> updateAuthorById(@PathVariable int authorId,
			@RequestBody Author author) {
		return authorService.updateAuthorById(authorId, author);
	}

	@DeleteMapping("/deleteAuthorById/{authorId}")
	public ResponseEntity<ResponseStructure<Author>> deleteAuthorById(@PathVariable int authorId) {
		return authorService.deleteAuthorById(authorId);
	}

	@DeleteMapping("/deleteAuthorByNationality/{nationality}")
	public ResponseEntity<ResponseStructure<List<Author>>> deleteAllAuthorByNationality(@PathVariable String nationality) {
		return authorService.deleteAllAuthorByNationality(nationality);
	}
}
