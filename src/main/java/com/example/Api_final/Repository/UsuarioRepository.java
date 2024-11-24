package com.example.Api_final.Repository;

import com.example.Api_final.dominio.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    List<UsuarioEntity>findAllByUsername(String username);
    List<UsuarioEntity>findAllByEmail(String email);
    List<UsuarioEntity>findAllByUsernameOREmail(String username, String email);

    @Query("SELECT u FROM UsuarioEntity u WHERE u.email LIKE :username")
    List<UsuarioEntity> retornarUsernames(@Param("username") String username);
}
