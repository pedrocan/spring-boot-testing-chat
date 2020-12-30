package com.examples.testing.chat.application;

import com.examples.testing.chat.domain.Chat;
import com.examples.testing.participante.Grupo;

public final class ChatRegistrationRequest {

    private final Chat chat;

    private final Grupo grupo;

    public ChatRegistrationRequest(Chat chat, Grupo grupo) {
        this.chat = chat;
        this.grupo = grupo;
    }

    public Chat getChat() {
        return chat;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    @Override
    public String toString() {
        return "ChatRegistrationRequest{" +
                "chat=" + chat +
                '}';
    }
}
