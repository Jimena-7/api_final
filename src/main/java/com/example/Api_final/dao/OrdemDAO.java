package com.example.Api_final.dao;

import com.example.Api_final.dominio.entity.OrdemEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class OrdemDAO {

    //FALTA CODIGO

    public OrdemEntity createOrdem(OrdemEntity ordemEntity){
        EntityManager entityManager;
        entityManager.getTransaction().begin();
        entityManager.persist(ordemEntity);
        entityManager.getTransaction().commit();
        return ordemEntity;
    }

    public List<OrdemEntity>getOrderByUsername(String username){
        EntityManager entitymanager;
        TypedQuery<OrdemEntity> query = entitymanager.createQuery(
            "SELECT o FROM o JOIN o.usuario u WHERE u.username", OrdemEntity.class);
            query.setParameter("username", username);
            List<OrdemEntity> orders = query.getResultList();
            return orders;
        }
    }

