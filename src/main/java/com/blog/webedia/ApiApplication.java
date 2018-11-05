package com.blog.webedia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blog.webedia.domain.Autor;
import com.blog.webedia.repositories.AutorRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Autor a1 = new Autor(null, "Autor 1");
		Autor a2 = new Autor(null, "Autor 2");
		Autor a3 = new Autor(null, "Autor 3");

		autorRepository.save(Arrays.asList(a1, a2, a3));
	}
}
