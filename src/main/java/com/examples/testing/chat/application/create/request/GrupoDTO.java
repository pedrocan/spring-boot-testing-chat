package com.examples.testing.chat.application.create.request;

import java.util.ArrayList;
import java.util.List;

public class GrupoDTO {

    String                grupoId;
    String                chatId;
    List<ParticipanteDTO> listaParticipantes = new ArrayList<>();

    public GrupoDTO() {
    }

    public String getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(String grupoId) {
        this.grupoId = grupoId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public List<ParticipanteDTO> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(List<ParticipanteDTO> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

}
