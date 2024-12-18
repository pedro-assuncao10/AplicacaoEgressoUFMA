package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "coordenador")
public class Coordenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coordenador", nullable = false)
    private Long idCoordenador;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "tipo", nullable = false)
    private String tipo = "egresso";

    // Getters and Setters
    public Long getIdCoordenador() {
        return idCoordenador;
    }

    public void setIdCoordenador(Long idCoordenador) {
        this.idCoordenador = idCoordenador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
