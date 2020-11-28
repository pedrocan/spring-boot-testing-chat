package com.examples.testing.chat.domain;

import com.examples.testing.participante.ListaParticipantesId;

import java.util.UUID;

public final class Chat {

    private ChatId id;

    private String name;

    private ListaParticipantesId listaParticipantesId;

    public Chat(ChatId id, String name) {

        if(id == null || id.value().isBlank() || id.value().isEmpty()){
            throw new IllegalArgumentException("Invalid ID");
        }
        if(name == null || name.isBlank() || name.isEmpty()){
            throw new IllegalArgumentException("Invalid name");
        }

        this.id = id;
        this.name = name;
        //this.listaParticipantesId = listaParticipantesId;
    }

    public ChatId id() {
        return id;
    }

    public String name() {
        return name;
    }


    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id.value() +
                ", name='" + name + '\'' +
                '}';
    }
}
