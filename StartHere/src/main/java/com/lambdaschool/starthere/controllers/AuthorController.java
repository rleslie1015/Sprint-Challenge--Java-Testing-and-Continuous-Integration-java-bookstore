package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.services.AuthorService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "authors")
public class AuthorController
{
	@Autowired
	private AuthorService authorService;

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@ApiOperation(value = "Returns all authors", response = Author.class, responseContainer = "List")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integr", paramType = "query",
					value = "Results page you want to retrieve (0..N)"),
			@ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
					value = "Number of records per page."),
			@ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
					value = "Sorting criteria in the format: property(,asc|desc). " +
							"Default sort order is ascending. " +
							"Multiple sort criteria are supported.")})
	@GetMapping(value = "/authors", produces = {"application/json"})
	public ResponseEntity<?> listAllAuthors()
	{
		ArrayList<Author> myAuthors = authorService.findall();
		return new ResponseEntity<>(myAuthors, HttpStatus.OK);
	}
}
