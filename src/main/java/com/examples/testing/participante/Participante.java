package com.examples.testing.participante;

import com.examples.testing.usuario.UsuarioId;

import java.util.Objects;

public class Participante {

    private UsuarioId usuarioId;

    private boolean esAdministrador;

    public Participante(UsuarioId usuarioId, Boolean esAdministrador) {
        this.usuarioId = usuarioId;
        this.esAdministrador = esAdministrador;
    }

    public void marcarAdmistrador(boolean admin){
        esAdministrador = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return esAdministrador == that.esAdministrador &&
                usuarioId.equals(that.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, esAdministrador);
    }

}
