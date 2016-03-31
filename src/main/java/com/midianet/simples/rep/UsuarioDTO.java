package com.midianet.simples.rep;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UsuarioDTO {
    private Long id;
    @NotNull
    @Size(min = 5, max = 80)
    private String nome;

    @NotNull
    @Size(min = 5, max = 20)
    private String login;

    @NotNull
    @Size(min = 5, max = 10)
    private String senha;

    @NotNull
    @Size(min = 5, max = 50)
    @Pattern(regexp = ".+@.+\\.[a-z]+")
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