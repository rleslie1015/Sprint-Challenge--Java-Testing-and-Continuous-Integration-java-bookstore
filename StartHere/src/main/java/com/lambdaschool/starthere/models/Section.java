package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section
{
	@Id
	private long sectionid;

	private String name;

	@OneToMany(mappedBy = "section")
	@JsonIgnoreProperties("section")
	private List<Book> books = new ArrayList<>();

	public long getSectionid()
	{
		return sectionid;
	}

	public void setSectionid(long sectionid)
	{
		this.sectionid = sectionid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Book> getBooks()
	{
		return books;
	}

	public void setBooks(List<Book> books)
	{
		this.books = books;
	}
}
