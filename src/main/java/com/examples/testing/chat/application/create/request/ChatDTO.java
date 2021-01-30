package com.examples.testing.chat.application.create.request;

import com.examples.testing.chat.domain.Chat;
import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.grupo.domain.Grupo;
import com.examples.testing.grupo.domain.GrupoId;
import com.examples.testing.grupo.domain.Participante;
import com.examples.testing.usuario.UsuarioId;

import java.util.ArrayList;
import java.util.List;

public class ChatDTO {

    String   id;
    String   name;
    GrupoDTO grupo;

    public ChatDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GrupoDTO getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoDTO grupo) {
        this.grupo = grupo;
    }

    public Chat toChatDomain() {
        ChatId chatId = new ChatId(this.id);
        return new Chat(chatId, getName());
    }

    public Grupo toGrupoDomain() {

        GrupoId            grupoId = new GrupoId(getGrupo().getGrupoId());
        List<Participante> lista   = new ArrayList<>();

        for (ParticipanteDTO participanteDTO : getGrupo().getListaParticipantes()) {
            lista.add(new Participante(new UsuarioId(participanteDTO.getUsuarioId()), participanteDTO.isEsAdministrador()));
        }

        return new Grupo(grupoId, new ChatId(this.id), lista);
    }


    public static ChatDTO toDTO(Chat chat, Grupo grupo) {

        List<ParticipanteDTO> lista = new ArrayList<>();
        for (Participante participante : grupo.getListaParticipantes()) {
            lista.add(new ParticipanteDTO(participante.getUsuarioId().value(), participante.esAdministrador()));
        }

        GrupoDTO grupoDTO = new GrupoDTO();
        grupoDTO.setChatId(chat.id().value());
        grupoDTO.setGrupoId(grupo.getGrupoId().value());
        grupoDTO.setListaParticipantes(lista);

        ChatDTO request = new ChatDTO();
        request.setId(chat.id().value());
        request.setName(chat.name());
        request.setGrupo(grupoDTO);

        return request;

    }

    public static ChatDTO toDTO(Chat chat) {

        ChatDTO request = new ChatDTO();
        request.setId(chat.id().value());
        request.setName(chat.name());

        return request;

    }

}

