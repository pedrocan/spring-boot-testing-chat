package com.examples.testing.mensaje;

import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.usuario.UsuarioId;

import java.util.Date;

public final class Mensaje {

    private final MensajeId id;

    private final String texto;

    private final Date fechaCreacion;

    private final UsuarioId usuarioCreacion;

    private final ChatId chatId;

    public Mensaje(MensajeId id, ChatId chatId, String texto, Date fechaCreacion, UsuarioId usuarioCreacion) {
        this.id              = id;
        this.texto           = texto;
        this.fechaCreacion   = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.chatId          = chatId;
    }
}
