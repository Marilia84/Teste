package com.teste.cadastrousuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.cadastrousuario.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Métodos personalizados, se necessário
}