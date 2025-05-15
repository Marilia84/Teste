package com.teste.cadastrousuario.controller;


import com.teste.cadastrousuario.model.Secretaria;
import com.teste.cadastrousuario.repository.SecretariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/secretarias")
@CrossOrigin(origins = "*")
public class SecretariaController {

    @Autowired
    private SecretariaRepository secretariaRepository;

    @PostMapping("/cadastrar")
    public Secretaria cadastrar(@RequestBody Secretaria secretaria) {
        return secretariaRepository.save(secretaria);
    }
}
