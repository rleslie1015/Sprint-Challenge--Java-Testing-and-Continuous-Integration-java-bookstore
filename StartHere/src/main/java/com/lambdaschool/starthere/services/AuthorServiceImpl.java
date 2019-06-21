package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class AuthorServiceImpl implements AuthorService
{
	@Autowired
	private AuthorRepository authrepos;
	@Override
	public ArrayList<Author> findall()
	{
		ArrayList<Author> list = new ArrayList<>();
		authrepos.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
}
