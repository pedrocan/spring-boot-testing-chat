package com.examples.testing.chat.application;

import com.examples.testing.chat.domain.Chat;
import com.examples.testing.participante.ListaParticipantes;

public final class ChatRegistrationRequest {

    private final Chat chat;

    private final ListaParticipantes listaParticipantes;

    public ChatRegistrationRequest(Chat chat, ListaParticipantes listaParticipantes) {
        this.chat = chat;
        this.listaParticipantes = listaParticipantes;
    }

    public Chat getChat() {
        return chat;
    }

    public ListaParticipantes getListaParticipantes() {
        return listaParticipantes;
    }

    @Override
    public String toString() {
        return "ChatRegistrationRequest{" +
                "chat=" + chat +
                '}';
    }
}
