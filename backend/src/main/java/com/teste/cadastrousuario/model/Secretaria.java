package com.teste.cadastrousuario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "secretaria")
public class Secretaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_secretaria;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    // Getters e Setters
    public Long getId_secretaria() {
        return id_secretaria;
    }

    public void setId_secretaria(Long id_secretaria) {
        this.id_secretaria = id_secretaria;
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
