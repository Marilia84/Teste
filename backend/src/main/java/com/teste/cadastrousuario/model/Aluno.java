package com.teste.cadastrousuario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aluno;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    // Getters e Setters
    public Long getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Long id_aluno) {
        this.id_aluno = id_aluno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.usuario = new Usuario();
        this.usuario.setId_usuario(idUsuario);
    }
}
