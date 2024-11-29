package com.example.Api_final.controller;

import com.example.Api_final.dominio.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    private com.example.Api_final.repository.UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public UsuarioEntity registerUser(@RequestBody UsuarioEntity usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/usuarios")
    public List<UsuarioEntity> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
}
