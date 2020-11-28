package com.examples.testing.participante;

import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.usuario.UsuarioId;

import java.util.Objects;

public class Participante {

    private UsuarioId usuarioId;

    private boolean esAdministrador;

    private ChatId chatId;

    public Participante(UsuarioId usuarioId, boolean esAdministrador, ChatId chatId) {
        this.usuarioId = usuarioId;
        this.esAdministrador = esAdministrador;
        this.chatId = chatId;
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
        return  Objects.equals(usuarioId, that.usuarioId) &&
                Objects.equals(chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, chatId);
    }
}
