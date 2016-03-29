package com.midianet.simples.rep;


public class UsuarioDTO {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(final String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(final boolean ativo) {
        this.ativo = ativo;
    }

}