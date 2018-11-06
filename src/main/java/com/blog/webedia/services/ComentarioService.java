package com.blog.webedia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.webedia.domain.Comentario;
import com.blog.webedia.repositories.ComentarioRepository;
import com.blog.webedia.services.exception.ObjectNotFoundException;

@Service
public class ComentarioService {
	@Autowired
	private ComentarioRepository repo;

	public Comentario buscar(Integer id) {
		Comentario obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado!" + "\nId: " + id + "\nTipo: " + Comentario.class.getName());
		}
		return obj;
	}
}
