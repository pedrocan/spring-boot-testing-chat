package com.examples.testing.chat.domain;

import com.examples.testing.chat.application.create.ChatRequest;

public interface ChatService {

    ChatId createChat(ChatRequest chat);

}
