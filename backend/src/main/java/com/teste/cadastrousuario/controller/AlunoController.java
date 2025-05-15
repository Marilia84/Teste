package com.teste.cadastrousuario.controller;

import com.teste.cadastrousuario.model.Aluno;
import com.teste.cadastrousuario.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin(origins = "*")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("/cadastrar")
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}
