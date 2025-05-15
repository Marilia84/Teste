package com.teste.cadastrousuario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professor;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    // Getters e Setters
    public Long getId_professor() {
        return id_professor;
    }

    public void setId_professor(Long id_professor) {
        this.id_professor = id_professor;
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
