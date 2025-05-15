package com.teste.cadastrousuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.cadastrousuario.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    // Métodos personalizados, se necessário
}
