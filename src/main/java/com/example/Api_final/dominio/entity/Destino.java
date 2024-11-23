package com.example.Api_final.dominio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private String localizacao;
    private List<Integer> avaliacoes = new ArrayList<>();
    private double mediaAvaliacoes;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<Integer> getAvaliacoes() {
        return avaliacoes;
    }
    public void setAvaliacoes(List<Integer> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    public double getMediaAvaliacoes() {
        return mediaAvaliacoes;
    }
    public void setMediaAvaliacoes(double mediaAvaliacoes) {
        this.mediaAvaliacoes = mediaAvaliacoes;
    }
    public void adicionarAvaliacao(int nota) {
        this.avaliacoes.add(nota);
        this.mediaAvaliacoes = this.avaliacoes.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }
}
