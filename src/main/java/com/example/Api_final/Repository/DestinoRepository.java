package com.example.Api_final.Repository;

import com.example.Api_final.entity.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DestinoRepository extends JpaRepository<Destino, Long>{
    List<Destino> findByNomeIgnoreCaseAndLocalizacaoIgnoreCase(String nome, String localizacao);

    List<Destino> findByDescricaoIgnoreCase(String descricao);
}