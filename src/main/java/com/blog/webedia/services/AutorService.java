package com.blog.webedia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.webedia.domain.Autor;
import com.blog.webedia.repositories.AutorRepository;

@Service
public class AutorService {
	@Autowired
	private AutorRepository repo;

	public Autor buscar(Integer id) {
		Autor obj = repo.findOne(id);
		return obj;
	}
}
