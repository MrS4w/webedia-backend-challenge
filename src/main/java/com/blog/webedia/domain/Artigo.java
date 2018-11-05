package com.blog.webedia.domain;

import java.io.Serializable;
import java.util.Date;

public class Artigo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private String subtitulo;
	private Date dataPublicacao;
	private Date ultimaAtualizacao;
	private String conteudo;
	private String permalink;

	public Artigo() {

	}

	public Artigo(Integer id, String titulo, String subtitulo, Date dataPublicacao, Date ultimaAtualizacao,
			String conteudo, Autor autor, String permalink) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.dataPublicacao = dataPublicacao;
		this.ultimaAtualizacao = ultimaAtualizacao;
		this.conteudo = conteudo;
		this.permalink = permalink;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Date getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(Date ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((permalink == null) ? 0 : permalink.hashCode());
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
		Artigo other = (Artigo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (permalink == null) {
			if (other.permalink != null)
				return false;
		} else if (!permalink.equals(other.permalink))
			return false;
		return true;
	}

}
