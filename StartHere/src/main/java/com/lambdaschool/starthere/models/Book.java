package com.lambdaschool.starthere.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book extends Auditable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookid;

	private String title;

	private String ISBN;

	private int copy;

	@ManyToMany(mappedBy = "books")
	@JsonIgnoreProperties("books")
	private List<Author> authors = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "sectionid")
	@JsonIgnoreProperties("book")
	//    @JsonView(View.CoursesOnly.class)
	private Section section;

	public long getBookid()
	{
		return bookid;
	}

	public void setBookid(long bookid)
	{
		this.bookid = bookid;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getISBN()
	{
		return ISBN;
	}

	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}

	public int getCopy()
	{
		return copy;
	}

	public void setCopy(int copy)
	{
		this.copy = copy;
	}

	public List<Author> getAuthors()
	{
		return authors;
	}

	public void setAuthors(List<Author> authors)
	{
		this.authors = authors;
	}

	public Section getSection()
	{
		return section;
	}

	public void setSection(Section section)
	{
		this.section = section;
	}
}
