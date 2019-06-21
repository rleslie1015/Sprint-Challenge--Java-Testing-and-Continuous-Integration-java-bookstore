package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends CrudRepository<Book, Long>
{
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO wrote(bookid, authorid) values (:bookid, :authorid)", nativeQuery = true)
	void assignBookAuthor(long bookid, long authorid);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM wrote WHERE bookid = :bookid", nativeQuery = true)
	void deleteBookFromAuthor(long bookid);
}
