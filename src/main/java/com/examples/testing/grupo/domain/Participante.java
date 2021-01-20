package com.examples.testing.grupo.domain;

import com.examples.testing.usuario.UsuarioId;

import java.util.Objects;

public class Participante {

    private UsuarioId usuarioId;
    private boolean esAdministrador;


    public Participante(UsuarioId usuarioId, boolean esAdministrador) {
        this.usuarioId = usuarioId;
        this.esAdministrador = esAdministrador;
    }

    public void marcarAdmistrador(boolean admin){
        esAdministrador = admin;
    }

    public boolean esAdministrador() {
        return esAdministrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return  Objects.equals(usuarioId, that.usuarioId) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId);
    }
}
