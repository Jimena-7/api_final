package com.example.Api_final.dominio.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class OrdemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private UsuarioEntity usuario;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public UsuarioEntity getUsuario(){
        return usuario;
    }


//FALTA CODIGO

}
