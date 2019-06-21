package com.lambdaschool.starthere.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
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
}
