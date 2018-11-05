package com.blog.webedia.domain;

import java.io.Serializable;

public class Artigo_Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Autor autor;
	private Artigo artigo;

	public Artigo_Autor() {

	}

	public Artigo_Autor(Integer id, Autor autor, Artigo artigo) {
		super();
		this.id = id;
		this.autor = autor;
		this.artigo = artigo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Artigo getArtigo() {
		return artigo;
	}

	public void setArtigo(Artigo artigo) {
		this.artigo = artigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artigo_Autor other = (Artigo_Autor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
