package com.examples.testing.chat.application;

import com.examples.testing.chat.domain.Chat;
import com.examples.testing.chat.domain.ChatRepository;
import com.examples.testing.participante.ListaParticipantes;
import com.examples.testing.participante.ParticipanteRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class ChatRegistrationService {

    private final ChatRepository chatRepository;

    private final ParticipanteRepository participanteRepository;

    @Autowired
    public ChatRegistrationService(ChatRepository chatRepository, ParticipanteRepository participanteRepository) {
        this.chatRepository = chatRepository;
        this.participanteRepository = participanteRepository;
    }

    public void registerNewChat(ChatRegistrationRequest request){

        //comprobaciones antes de guardar + testear comprobaciones
        //crear chat + tema + obtener id
        //seleccionar lista usuarios participantes
        //seleccionar un admin
        Chat chat = request.getChat();

        //lista cubierta en la request

        ListaParticipantes listaParticipantes = request.getListaParticipantes();
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

        participanteRepository.save(listaParticipantes);



    }
}
