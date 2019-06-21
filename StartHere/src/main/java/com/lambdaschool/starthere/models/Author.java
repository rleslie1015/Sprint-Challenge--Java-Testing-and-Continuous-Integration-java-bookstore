package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends Auditable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long authorid;

	private String fname;

	private String lname;

	@ManyToMany
	@JoinTable(name = "authbooks",
			joinColumns = {@JoinColumn(name = "authorid")},
			inverseJoinColumns = {@JoinColumn(name = "bookid")})
	@JsonIgnoreProperties("authors")
	private List<Book> books = new ArrayList<>();

	
}
