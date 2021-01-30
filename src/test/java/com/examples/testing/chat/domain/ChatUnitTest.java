package com.examples.testing.chat.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChatUnitTest {

    @Test
    void itShouldIllegalArgExceptionIdNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            Chat chat = new Chat(null, "proba");
        });
    }

    @Test
    void itShouldIllegalArgExceptionNameNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            ChatId chatId = new ChatId(UUID.randomUUID().toString());
            Chat   chat   = new Chat(chatId, null);
        });

    }

}
