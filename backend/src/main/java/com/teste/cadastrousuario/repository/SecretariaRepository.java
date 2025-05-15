package com.teste.cadastrousuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.cadastrousuario.model.Secretaria;
@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário
    // Exemplo: List<Secretaria> findByNome(String nome);
    
}
