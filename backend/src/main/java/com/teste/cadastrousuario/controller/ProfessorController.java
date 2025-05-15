package com.teste.cadastrousuario.controller;

import com.teste.cadastrousuario.model.Professor;
import com.teste.cadastrousuario.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professores")
@CrossOrigin(origins = "*") // Permite requisições do frontend
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping("/cadastrar")
    public Professor cadastrar(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }
}
