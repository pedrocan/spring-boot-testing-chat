package com.examples.testing.chat.application;

import com.examples.testing.chat.domain.Chat;
import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.chat.domain.ChatRepository;
import com.examples.testing.participante.ListaParticipantes;
import com.examples.testing.participante.Participante;
import com.examples.testing.participante.ParticipanteRepository;
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import static org.assertj.core.api.Assertions.assertThat;

public final class ChatRegistrationTest {

@Mock
ChatRepository chatRepository;

@Mock
ParticipanteRepository participanteRepository;

ChatRegistrationService underTest;

@Captor
ArgumentCaptor<Chat> chatArgumentCaptor;

@BeforeEach
void setUp() {
    MockitoAnnotations.initMocks(this);
    underTest = new ChatRegistrationService(chatRepository,participanteRepository);
}

@Test
void itShouldSaveNewChat(){
    ChatId chatId = new ChatId(UUID.randomUUID().toString());
    Chat chat = new Chat(chatId, "NEW CHAT");

    UsuarioId usuarioId= new UsuarioId(UUID.randomUUID().toString());
    UsuarioId usuarioId2= new UsuarioId(UUID.randomUUID().toString());
    Participante participante = new Participante(usuarioId, Boolean.FALSE, chatId);
    Participante participante2 = new Participante(usuarioId2, Boolean.TRUE, chatId);

    List<Participante> lista = new ArrayList<>();
    lista.add(participante);
    lista.add(participante2);

    ListaParticipantes listaParticipantes = new ListaParticipantes(chat.id(), lista );

    //a request
    ChatRegistrationRequest request = new ChatRegistrationRequest(chat, listaParticipantes);

    //given
    //no previous chat with id
    given(chatRepository.findById(request.getChat().id())).willReturn(Optional.empty());

    //when
    underTest.registerNewChat(request);

    //then
    then(chatRepository).should().save(chatArgumentCaptor.capture());
    Chat chatArgumentValue = chatArgumentCaptor.getValue();
    assertThat(chatArgumentValue).isEqualTo(chat);

}


}
