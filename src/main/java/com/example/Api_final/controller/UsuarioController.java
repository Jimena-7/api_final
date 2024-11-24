package com.example.Api_final.controller;

import com.example.Api_final.dominio.dto.UsuarioDTO;
import com.example.Api_final.servico.OrdemServico;
import com.example.Api_final.servico.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioServico usuarioServico;
    @Autowired
    private OrdemServico ordemServico;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>>getAllUsers(){
    List<UsuarioDTO> usuarios = usuarioServico.getAllUsers();
    return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO>getUsersById(@PathVariable Long id){
        UsuarioDTO usuario = (UsuarioDTO) usuarioServico.getAllUsers();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

//falta codigo
}
