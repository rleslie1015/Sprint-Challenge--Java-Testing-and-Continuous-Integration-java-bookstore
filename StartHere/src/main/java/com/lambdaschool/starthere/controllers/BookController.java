package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.models.ErrorDetail;
import com.lambdaschool.starthere.services.BookService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "books")
public class BookController
{
	@Autowired
	private BookService bookservice;

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@ApiOperation(value = "Returns all Books", response = Book.class, responseContainer = "List")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integr", paramType = "query",
					value = "Results page you want to retrieve (0..N)"),
			@ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
					value = "Number of records per page."),
			@ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
					value = "Sorting criteria in the format: property(,asc|desc). " +
							"Default sort order is ascending. " +
							"Multiple sort criteria are supported.")})
	@GetMapping(value = "/books", produces = {"application/json"})
	public ResponseEntity<?> findAllBooks(
			@PageableDefault(
					page = 0,
					size = 3)
					Pageable pageable)
	{
		ArrayList<Book> myBooks = bookservice.findAll(pageable);
		return new ResponseEntity<>(myBooks, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@ApiOperation(value = "Retrieves a book associated with the bookid.", response = Book.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Book Found", response = Book.class),
			@ApiResponse(code = 404, message = "Book Not Found", response = ErrorDetail.class)})
	@PutMapping(value = "/data/books/{id}", produces = {"application/json"})
	public ResponseEntity<?> updateBook(
			@RequestBody
				Book updatedBook,
			@PathVariable
				long id)
	{
		bookservice.update(updatedBook, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@ApiOperation(value = " assigns a book already in the system to an author already in the system", response = void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Author Added to Book Successfully", response = void.class),
			@ApiResponse(code = 500, message = "Error adding author to book", response = ErrorDetail.class)
	} )
	@PostMapping(value = "/data/books/{bookid}/authors/{authid}",produces = {"application/json"})
	public ResponseEntity<?> assignBookAuth(
			@PathVariable
			long bookid,
			@PathVariable
			long authid)
	{
		bookservice.updateBookAuth(bookid, authid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@ApiOperation(value = "Deletes an existing book.", response = void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Book deleted Successfully", response = void.class),
			@ApiResponse(code = 500, message = "Error deleting book", response = ErrorDetail.class)
	} )
	@DeleteMapping(value = "data/books/{id}", produces = {"application/json"})
	public ResponseEntity<?> deleteBookFromAuth(
			@PathVariable
			long id)
	{
		bookservice.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
