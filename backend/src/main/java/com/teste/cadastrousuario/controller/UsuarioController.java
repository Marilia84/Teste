package com.teste.cadastrousuario.controller;

import com.teste.cadastrousuario.model.Aluno;
import com.teste.cadastrousuario.model.Professor;
import com.teste.cadastrousuario.model.Secretaria;
import com.teste.cadastrousuario.model.Usuario;
import com.teste.cadastrousuario.repository.AlunoRepository;
import com.teste.cadastrousuario.repository.ProfessorRepository;
import com.teste.cadastrousuario.repository.SecretariaRepository;
import com.teste.cadastrousuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Permite requisições do frontend React local
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SecretariaRepository secretariaRepository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return ResponseEntity.badRequest().body("Email já cadastrado");
        }
        Usuario salvo = usuarioRepository.save(usuario);

        if ("Secretaria".equals(usuario.getTipo())) {
            Secretaria secretaria = new Secretaria();
            secretaria.setIdUsuario(salvo.getId_usuario()); // Associa o id_usuario à secretaria
            secretariaRepository.save(secretaria);
        } else if ("Aluno".equals(usuario.getTipo())) {
            Aluno aluno = new Aluno();
            aluno.setIdUsuario(salvo.getId_usuario()); // Associa o id_usuario ao aluno
            alunoRepository.save(aluno);
        } else if ("Professor".equals(usuario.getTipo())) {
            Professor professor = new Professor();
            professor.setIdUsuario(salvo.getId_usuario()); // Associa o id_usuario ao professor
            professorRepository.save(professor);
        }
        return ResponseEntity.ok(salvo);
    }
}
