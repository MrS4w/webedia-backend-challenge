package com.blog.webedia.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.webedia.domain.Autor;

@RestController
@RequestMapping(value = "autores")
public class AutorResource {
	@RequestMapping(method = RequestMethod.GET)
	public List<Autor> listar() {
		Autor a1 = new Autor(1, "Victor");
		Autor a2 = new Autor(2, "Antonio");
		
		List<Autor> lista = new ArrayList<>();
		lista.add(a1);
		lista.add(a2);
		return lista;
	}
}
