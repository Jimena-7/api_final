package com.example.Api_final.servico;

import com.example.Api_final.repository.DestinoRepository;
import com.example.Api_final.dominio.entity.Destino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class DestinoServico {
@Autowired
    private DestinoRepository destinoRepository;

    public List<Destino> getAllDestinos() {
        return destinoRepository.findAll();
    }
    public Optional <Destino> getDestinoById(Long id) {
        return destinoRepository.findById(id);
    }
    public Destino createDestino(Destino destino) {
        destinoRepository.save(destino);
        return destino;
    }
    public Destino updateDestino(Long id, Destino destino) {
        destino.setId(id);
        destinoRepository.save(destino);
        return destino;
    }
    public void deleteDestino(Long id) {
        destinoRepository.deleteById(id);
    }
    public List<Destino> pesquisarDestinos(String nome, String localizacao) {
        return destinoRepository.findByNomeIgnoreCaseAndLocalizacaoIgnoreCase(nome, localizacao);
    }
    public List<Destino> pesquisarDestinosPorDescricao(String descricao) {
        return destinoRepository.findByDescricaoIgnoreCase(descricao);
    }
    public Optional<Destino> avaliarDestino(Long id, int nota) {
        Optional<Destino> destinoOptional = destinoRepository.findById(id);
        destinoOptional.ifPresent(destino -> {
            destino.adicionarAvaliacao(nota);
            destinoRepository.save(destino);
        });
        return destinoOptional;
    }
}
