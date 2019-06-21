package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Book;

import java.util.ArrayList;

public interface BookService
{
	ArrayList<Book> findAll();

	Book update(Book book, long id);

	void updateBookAuth(long bookid, long authid);

	void deleteBook(long id);

}
