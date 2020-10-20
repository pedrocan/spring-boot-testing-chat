package com.examples.testing.chat.application;

import com.examples.testing.chat.domain.Chat;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class ChatRegistrationRequest {

    private final Chat chat;

    public ChatRegistrationRequest(@JsonProperty("chat") Chat chat) {
        this.chat = chat;
    }

    public Chat getChat() {
        return chat;
    }

    @Override
    public String toString() {
        return "ChatRegistrationRequest{" +
                "chat=" + chat +
                '}';
    }
}
