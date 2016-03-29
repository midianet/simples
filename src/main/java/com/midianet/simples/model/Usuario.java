package com.midianet.simples.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String nome;

	private String login;

	private String senha;

	private String email;

	private boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

}
