package com.blog.webedia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
