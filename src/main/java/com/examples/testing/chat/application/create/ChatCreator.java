package com.examples.testing.chat.application.create;

import com.examples.testing.chat.application.create.request.ChatDTO;
import com.examples.testing.chat.domain.Chat;
import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.chat.domain.ChatRepository;
import com.examples.testing.grupo.domain.Grupo;
import com.examples.testing.grupo.domain.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public final class ChatCreator {

    private final ChatRepository  chatRepository;
    private final GrupoRepository grupoRepository;

    @Autowired
    public ChatCreator(ChatRepository chatRepository, GrupoRepository grupoRepository) {
        this.chatRepository  = chatRepository;
        this.grupoRepository = grupoRepository;
    }

    public ChatId createChat(ChatDTO request) {

        //comprobaciones antes de guardar + testear comprobaciones
        //crear chat + tema + obtener id
        //seleccionar lista usuarios participantes
        //seleccionar un admin

        //request chat id + name + grupo id --> new chat
        //request grupo id + chat id + lista participantes --> grupo
        //ChatId chatId = new ChatId(request.getId());
        //Chat chat = new Chat(chatId, request.getName());
        //Grupo grupo = request.getGrupo();
        Chat  chat  = request.toChatDomain();
        Grupo grupo = request.toGrupoDomain();

        chatRepository.save(chat);
        grupoRepository.save(grupo);

        return chat.id();

    }


}
