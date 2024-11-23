package com.example.Api_final.dao;


import com.example.Api_final.dominio.entity.UsuarioEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioDAO {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public UsuarioDAO(){
        entityManagerFactory = Persistence.createEntityManagerFactory("viagens");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<UsuarioEntity>getAllUsers() {
        return entityManager.createQuery("SELECT u FROM UsuarioEntity u", UsuarioEntity.class).getResultList();
    }
    }

