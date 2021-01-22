package com.examples.testing.grupo.domain;

import com.examples.testing.chat.domain.ChatId;

import java.util.List;

public class Grupo {

    private final GrupoId grupoId;
    private final ChatId chatId;
    private final List<Participante> listaParticipantes;

    public Grupo(GrupoId grupoId, ChatId chatId, List<Participante> listaParticipantes) {

        //existe un chat asociado a la lista
        if(chatId == null || chatId.value().isBlank() || chatId.value().isEmpty()){
            throw new IllegalArgumentException("Invalid ChatId");
        }

        //existe mas de una persona en la lista
        if(listaParticipantes == null || listaParticipantes.size() < 2 ){
            throw new IllegalArgumentException("Invalid null/size listaParticipantes");
        }

        //existe un administrador en la lista
        if(listaParticipantes !=null ){

                listaParticipantes.stream()
                    .filter(Participante::esAdministrador).findAny()
                    .orElseThrow(() -> new IllegalArgumentException("Invalid listaParticipanes without admin"));
        }

        this.chatId = chatId;
        this.listaParticipantes = listaParticipantes;
        this.grupoId = grupoId;

    }

    public GrupoId getGrupoId() {
        return grupoId;
    }

    public List<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public void anhadirParticipante(Participante participante) {
        if(listaParticipantes != null) {
            listaParticipantes.add(participante);
        }
    }

    public void eliminarParticipante(Participante participante){
        if(listaParticipantes != null) {
            listaParticipantes.remove(participante);
        }
    }

    public void establecerAdministrador(Participante participante, boolean esAdmin){

        for(Participante busquedaParticipante : listaParticipantes) {
            if(busquedaParticipante == participante) {
                participante.marcarAdmistrador(esAdmin);
            }
        }
    }
}
