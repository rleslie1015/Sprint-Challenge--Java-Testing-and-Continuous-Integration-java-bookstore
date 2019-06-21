package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "bookservice")
public class BookServiceImpl implements BookService
{
	@Autowired
	BookRepository bookrepos;


	@Override
	public ArrayList<Book> findAll(Pageable pageable)
	{
		ArrayList<Book> list = new ArrayList<>();
		bookrepos.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Book update(Book book, long id)
	{
		Book currentBook = bookrepos.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

		if (book.getTitle() != null)
		{
			currentBook.setTitle(book.getTitle());
		}
		if (book.getCopy() > 0)
		{
			currentBook.setCopy(book.getCopy());
		}
		if (book.getISBN() != null)
		{
			currentBook.setISBN(book.getISBN());
		}

		return bookrepos.save(currentBook);
	}

	@Override
	public void updateBookAuth(long bookid, long authid)
	{
		bookrepos.assignBookAuthor(bookid, authid);
	}



	@Override
	public void delete(long id) throws EntityNotFoundException
	{
		if (bookrepos.findById(id).isPresent())
		{
		bookrepos.deleteBookFromAuthor(id);
		bookrepos.deleteById(id);
		} else
		{
			throw new EntityNotFoundException(Long.toString(id));
		}
	}
}
