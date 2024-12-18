package com.example.demo.dto;

import com.example.demo.model.Depoimento;

public class DepoimentoRequisicaoDTO {

    private Integer idDepoimento;
    private Integer idEgresso;
    private String texto;

    // Getters e Setters
    public Integer getIdDepoimento() {
        return idDepoimento;
    }

    public void setIdDepoimento(Integer idDepoimento) {
        this.idDepoimento = idDepoimento;
    }

    public Integer getIdEgresso() {
        return idEgresso;
    }

    public void setIdEgresso(Integer idEgresso) {
        this.idEgresso = idEgresso;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    // Método para converter DTO em entidade Depoimento
    public Depoimento toDepoimento() {
        Depoimento depoimento = new Depoimento();
        depoimento.setTexto(this.texto);
        return depoimento;
    }
}
