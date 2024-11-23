package com.example.Api_final.dominio.entity;

import jakarta.persistence.*;

@Entity
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String role;

    public Long getId(){return id;}
    public void setId(Long id) {this.id = id;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getRole(){return role;}
    public void SetRole(String role){this.role = role;}
}

