package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "bookservice")
public class BookServiceImpl implements BookService
{
	@Autowired
	BookRepository bookrepos;

	@Override
	public ArrayList<Book> findAll()
	{
		ArrayList<Book> list = new ArrayList<>();
		bookrepos.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
}
