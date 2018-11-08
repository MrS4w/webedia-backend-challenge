package com.blog.webedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
					"Objeto não encontrado!" + " Id: " + id + " Tipo: " + Artigo.class.getName());
		}
		return obj;
	}

	public Artigo insert(Artigo obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Artigo update(Artigo obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		repo.delete(id);
	}

	public List<Artigo> findAll() {
		return repo.findAll();
	}

	public Page<Artigo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
