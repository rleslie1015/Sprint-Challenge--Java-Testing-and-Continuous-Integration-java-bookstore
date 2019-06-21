package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "books")
public class BookController
{
	@Autowired
	private BookService bookservice;

	@RequestMapping(value = "/books", produces = {"application/json"})
	public ResponseEntity<?> findAllBooks()
	{
		ArrayList<Book> myBooks = bookservice.findAll();
		return new ResponseEntity<>(myBooks, HttpStatus.OK);
	}


}
