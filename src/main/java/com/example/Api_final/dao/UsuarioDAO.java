package com.example.Api_final.dao;


import com.example.Api_final.dominio.entity.UsuarioEntity;
import jakarta.persistence.*;
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
        return entityManager.createQuery
                ("SELECT u FROM UsuarioEntity u", UsuarioEntity.class).getResultList();
    }
    public UsuarioEntity getUserById(Long id){return entityManager.find(UsuarioEntity.class, id);
    }

    public UsuarioEntity createUser(UsuarioEntity usuarioEntity){
        entityManager.getTransaction().begin();
        entityManager.persist(usuarioEntity);
        entityManager.getTransaction().commit();
        return usuarioEntity;
    }
    public UsuarioEntity updateUser(UsuarioEntity usuarioEntity){
        entityManager.getTransaction().begin();
        entityManager.persist(usuarioEntity);
        entityManager.getTransaction().commit();
        return usuarioEntity;
    }
    public void deleteUser(Long id){
        entityManager.getTransaction().begin();
        UsuarioEntity usuario = entityManager.find(UsuarioEntity.class, id);
        if (usuario != null){
            entityManager.remove(usuario);
        }
        entityManager.getTransaction().commit();
    }
    public List<UsuarioEntity>getUserByEmail(String email){
        TypedQuery<UsuarioEntity>query = entityManager.createQuery(
                "SELECT u FROM UsuarioEntity u WHERE u.email LIKE :email", UsuarioEntity.class);
        query.setParameter("email", email);
        List<UsuarioEntity> usuarios = query.getResultList();
        return usuarios;
    }
    public List<UsuarioEntity>getUserByUsername(String username){
        TypedQuery<UsuarioEntity>query = entityManager.createQuery(
                "SELECT u FROM UsuarioEntity u WHERE u.email LIKE :username", UsuarioEntity.class);
        query.setParameter("email", username);
        List<UsuarioEntity> usuarios = query.getResultList();
        return usuarios;
    }
    public List<UsuarioEntity>findUsersByRole(String role){
        String nativeQuery = "SELECT* FROM usuarioentity WHERE role = :role";
        Query query = entityManager.createNativeQuery(nativeQuery, UsuarioEntity.class);
        query.setParameter("role", role);
        return query.getResultList();
    }
    }


