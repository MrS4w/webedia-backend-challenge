package com.blog.webedia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.webedia.domain.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Integer> {

}
