package com.blog.webedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.blog.webedia.domain.Comentario;
import com.blog.webedia.repositories.ComentarioRepository;
import com.blog.webedia.services.exception.ObjectNotFoundException;

@Service
public class ComentarioService {
	@Autowired
	private ComentarioRepository repo;

	public Comentario find(Integer id) {
		Comentario obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado!" + " Id: " + id + " Tipo: " + Comentario.class.getName());
		}
		return obj;
	}

	public Comentario insert(Comentario obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Comentario update(Comentario obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		repo.delete(id);
	}

	public List<Comentario> findAll() {
		return repo.findAll();
	}

	public Page<Comentario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
