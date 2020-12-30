package com.examples.testing.chat.application.create;

import com.examples.testing.chat.application.ChatRegistrationRequest;
import com.examples.testing.chat.domain.Chat;
import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.chat.domain.ChatRepository;
import com.examples.testing.participante.Grupo;
import com.examples.testing.participante.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public final class ChatCreator{

    private final ChatRepository chatRepository;
    private final GrupoRepository grupoRepository;

    @Autowired
    public ChatCreator(ChatRepository chatRepository, GrupoRepository grupoRepository) {
        this.chatRepository = chatRepository;
        this.grupoRepository = grupoRepository;
    }

    public ChatId createChat(ChatRegistrationRequest request){

        //comprobaciones antes de guardar + testear comprobaciones
        //crear chat + tema + obtener id
        //seleccionar lista usuarios participantes
        //seleccionar un admin
        Chat chat = request.getChat();

        //lista cubierta en la request

        Grupo grupo = request.getGrupo();
        /*
        ListaParticipantes listaParticipantes = new ListaParticipantes();

        Participante participante1 = new Participante(UUID.randomUUID(), Boolean.FALSE, chat.id());
        Participante participante2 = new Participante(UUID.randomUUID(), Boolean.FALSE, chat.id());
        Participante participante3 = new Participante(UUID.randomUUID(), Boolean.TRUE,chat.id());

        listaParticipantes.anhadirParticipante(participante1);
        listaParticipantes.anhadirParticipante(participante2);
        listaParticipantes.anhadirParticipante(participante3);
        */
        //

        chatRepository.save(request.getChat());

        grupoRepository.save(grupo);

        return request.getChat().id();

    }
}
