package com.blog.webedia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.webedia.domain.Artigo;
import com.blog.webedia.services.ArtigoService;

@RestController
@RequestMapping(value = "/artigos")
public class ArtigoResource {

	@Autowired
	private ArtigoService service;

	@RequestMapping(value = "/artigo{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Artigo obj = service.buscar(id);

		return ResponseEntity.ok().body(obj);
	}
}
