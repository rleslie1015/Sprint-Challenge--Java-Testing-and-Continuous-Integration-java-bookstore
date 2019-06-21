package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "authorservice")
public class AuthorServiceImpl implements AuthorService
{
	@Autowired
	private AuthorRepository authrepos;

	@Override
	public ArrayList<Author> findall(Pageable pageable)
	{
		ArrayList<Author> list = new ArrayList<>();
		authrepos.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
}
