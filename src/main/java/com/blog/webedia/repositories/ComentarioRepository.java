package com.blog.webedia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.webedia.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}
