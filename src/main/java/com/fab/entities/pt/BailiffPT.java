package com.fab.entities.pt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class BailiffPT {
    @JsonProperty("nome")
    private String nome;

    @JsonProperty("numcedula")
    private String numcedula;

    @JsonProperty("tipoassociado")
    private String tipoassociado;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("WS_Morada")
    private List<BailiffPTMorada> morada;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumcedula() {
        return numcedula;
    }

    public void setNumcedula(String numcedula) {
        this.numcedula = numcedula;
    }

    public String getTipoassociado() {
        return tipoassociado;
    }

    public void setTipoassociado(String tipoassociado) {
        this.tipoassociado = tipoassociado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<BailiffPTMorada> getMorada() {
        return morada;
    }

    public void setMorada(List<BailiffPTMorada> morada) {
        this.morada = morada;
    }
}
