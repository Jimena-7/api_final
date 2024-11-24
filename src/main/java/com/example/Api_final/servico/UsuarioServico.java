package com.example.Api_final.servico;

import com.example.Api_final.Repository.UsuarioRepository;
import com.example.Api_final.dominio.dto.UsuarioDTO;
import com.example.Api_final.dominio.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServico {
    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioDTO> getAllUsers() {
        List<UsuarioEntity> usuarios = repository.findAll();
        return usuarios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO getUserById(Long id){
        UsuarioEntity usuario = repository.getReferenceById(id);
        return convertToDTO(usuario);
    }

    public List<UsuarioEntity>getUserByRole(String role){
        List<UsuarioEntity> usuarios = usuarioDAO.findUserByRole(role);
        return usuarios;
    }

}

