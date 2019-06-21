package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Book;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface BookService
{
	ArrayList<Book> findAll(Pageable pageable);

	Book update(Book book, long id);

	void updateBookAuth(long bookid, long authid);

//	void deleteBook(long id);

	void delete(long id);

}
