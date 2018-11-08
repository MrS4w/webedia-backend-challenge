package com.blog.webedia.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blog.webedia.domain.Comentario;
import com.blog.webedia.services.ComentarioService;

@RestController
@RequestMapping(value = "/comentarios")
public class ComentarioResource {

	@Autowired
	private ComentarioService service;

	@RequestMapping(value = "/comentario{id}", method = RequestMethod.GET)
	public ResponseEntity<Comentario> find(@PathVariable Integer id) {
		Comentario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Comentario obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/comentario{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/comentario{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Comentario obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/comentario{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Comentario>> findAll() {
		List<Comentario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Comentario>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "comentario") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Comentario> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
}
