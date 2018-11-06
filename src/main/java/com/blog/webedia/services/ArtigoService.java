package com.blog.webedia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.webedia.domain.Artigo;
import com.blog.webedia.repositories.ArtigoRepository;
import com.blog.webedia.services.exception.ObjectNotFoundException;

@Service
public class ArtigoService {
	@Autowired
	private ArtigoRepository repo;

	public Artigo find(Integer id) {
		Artigo obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado!" + "\nId: " + id + "\nTipo: " + Artigo.class.getName());
		}
		return obj;
	}
}
