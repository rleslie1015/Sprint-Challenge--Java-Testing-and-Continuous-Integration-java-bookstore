package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "authors")
public class AuthorController
{
	@Autowired
	private AuthorService authorService;

	@RequestMapping(value = "/authors", produces = {"application/json"})
	public ResponseEntity<?> listAllAuthors()
	{
		ArrayList<Author> myAuthors = authorService.findall();
		return new ResponseEntity<>(myAuthors, HttpStatus.OK);
	}
}
