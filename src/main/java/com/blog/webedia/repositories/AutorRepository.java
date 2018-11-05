package com.blog.webedia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.webedia.domain.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
	
}
