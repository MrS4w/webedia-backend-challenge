package com.blog.webedia.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blog.webedia.domain.Artigo;
import com.blog.webedia.domain.Autor;
import com.blog.webedia.domain.Comentario;
import com.blog.webedia.services.ArtigoService;
import com.blog.webedia.services.exception.DataIntegrityException;

@RestController
@RequestMapping(value = "/artigos")
public class ArtigoResource {

	@Autowired
	private ArtigoService service;

	@RequestMapping(value = "/artigo{id}", method = RequestMethod.GET)
	public ResponseEntity<Artigo> find(@PathVariable Integer id) {
		Artigo obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Artigo obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/artigo{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/artigo{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Artigo obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/artigo{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Artigo obj, @PathVariable Integer id) {
		try {
			obj.setId(id);
			List<Autor> listA = new ArrayList<>();
			List<Comentario> listC = new ArrayList<>();
			obj.setAutores(listA);
			obj.setComentarios(listC);
			obj = service.update(obj);
			service.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um artigo que possui autores!");
		}
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Artigo>> findAll() {
		List<Artigo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Artigo>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "titulo") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Artigo> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
}
