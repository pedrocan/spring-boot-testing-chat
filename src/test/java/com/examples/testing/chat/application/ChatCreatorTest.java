package com.examples.testing.chat.application;

import com.examples.testing.chat.application.create.request.ChatDTO;
import com.examples.testing.chat.domain.Chat;
import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.chat.application.create.ChatCreator;
import com.examples.testing.chat.domain.ChatRepository;
import com.examples.testing.grupo.domain.Grupo;
import com.examples.testing.grupo.domain.GrupoId;
import com.examples.testing.grupo.domain.Participante;
import com.examples.testing.grupo.domain.GrupoRepository;
import com.examples.testing.usuario.UsuarioId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import static org.assertj.core.api.Assertions.assertThat;

public final class ChatCreatorTest {

@Mock
ChatRepository chatRepository;

@Mock
GrupoRepository grupoRepository;

ChatCreator underTest;

@Captor
ArgumentCaptor<Chat> chatArgumentCaptor;

@BeforeEach
void setUp() {
    MockitoAnnotations.initMocks(this);
    underTest = new ChatCreator(chatRepository, grupoRepository);
}

@Test
void itShouldSaveNewChat(){

    //Refactor DTO -> Creator
    //Eliminar entidades -> creator para testear desde aplicacion

    ChatId chatId = new ChatId(UUID.randomUUID().toString());
    GrupoId grupoId = new GrupoId(UUID.randomUUID().toString());
    Chat chat = new Chat(chatId, "NEW CHAT");

    UsuarioId usuarioId= new UsuarioId(UUID.randomUUID().toString());
    UsuarioId usuarioId2= new UsuarioId(UUID.randomUUID().toString());
    Participante participante = new Participante(usuarioId, Boolean.FALSE);
    Participante participante2 = new Participante(usuarioId2, Boolean.TRUE);

    List<Participante> lista = new ArrayList<>();
    lista.add(participante);
    lista.add(participante2);

    Grupo grupo = new Grupo(grupoId, chat.id(), lista);

    //a request
    ChatDTO request = ChatDTO.toDTO(chat, grupo);

    //given
    //no previous chat with id
    given(chatRepository.findById(new ChatId(request.getId()))).willReturn(Optional.empty());

    //when
    underTest.createChat(request);

    //then
    then(chatRepository).should().save(chatArgumentCaptor.capture());
    Chat chatArgumentValue = chatArgumentCaptor.getValue();
    assertThat(chatArgumentValue).isEqualTo(chat);

}


}
