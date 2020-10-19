package com.examples.testing.chat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import static org.assertj.core.api.Assertions.assertThat;

public final class ChatRegistrationTest {

@Mock
ChatRepository chatRepository;

ChatRegistrationService underTest;

@Captor
ArgumentCaptor<Chat> chatArgumentCaptor;

@BeforeEach
void setUp() {
    MockitoAnnotations.initMocks(this);
    underTest = new ChatRegistrationService(chatRepository);
}

@Test
void itShouldSaveNewChat(){

    Chat chat = new Chat(UUID.randomUUID(), "NEW CHAT");

    //a request
    ChatRegistrationRequest request = new ChatRegistrationRequest(chat);

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
@Test
void itShouldIllegalArgExceptionIdNull() {

    assertThrows(IllegalArgumentException.class, () -> {
        Chat chat = new Chat(null, "proba");
    });
}

@Test
void itShouldIllegalArgExceptionNameNull(){

    assertThrows(IllegalArgumentException.class, () -> {
        Chat chat = new Chat(UUID.randomUUID(),null);
    });

}

}
