package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "books")
public class BookController
{
	@Autowired
	private BookService bookservice;

	@GetMapping(value = "/books", produces = {"application/json"})
	public ResponseEntity<?> findAllBooks()
	{
		ArrayList<Book> myBooks = bookservice.findAll();
		return new ResponseEntity<>(myBooks, HttpStatus.OK);
	}

	@PutMapping(value = "/books/{id}", produces = {"application/json"})
	public ResponseEntity<?> updateBook(
			@RequestBody
				Book updatedBook,
			@PathVariable
				long id)
	{
		bookservice.update(updatedBook, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
