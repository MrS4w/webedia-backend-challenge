package com.blog.webedia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blog.webedia.domain.Autor;
import com.blog.webedia.domain.Comentario;
import com.blog.webedia.repositories.AutorRepository;
import com.blog.webedia.repositories.ComentarioRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private ComentarioRepository comentarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Autor a1 = new Autor(null, "Autor 1");
		Autor a2 = new Autor(null, "Autor 2");
		Autor a3 = new Autor(null, "Autor 3");

		Comentario c1 = new Comentario(null, "comment1");
		Comentario c2 = new Comentario(null, "comment2");
		Comentario c3 = new Comentario(null, "comment3");

		comentarioRepository.save(Arrays.asList(c1, c2, c3));
		autorRepository.save(Arrays.asList(a1, a2, a3));
	}
}
