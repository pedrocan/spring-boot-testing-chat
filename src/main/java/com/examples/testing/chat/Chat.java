package com.examples.testing.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.examples.testing.participante.ListaParticipantesId;

import java.util.UUID;

@JsonIgnoreProperties(allowGetters = true)
public final class Chat {

    private UUID id;

    private String name;

    private ListaParticipantesId listaParticipantesId;


    public Chat(UUID id, String name) {

        if(id == null || id.toString().isBlank() || id.toString().isEmpty()){
            throw new IllegalArgumentException("Invalid ID");
        }
        if(name == null || name.isBlank() || name.isEmpty()){
            throw new IllegalArgumentException("Invalid name");
        }

        this.id = id;
        this.name = name;
        //this.listaParticipantesId = listaParticipantesId;
    }

    public UUID id() {
        return id;
    }

    public String name() {
        return name;
    }


    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
