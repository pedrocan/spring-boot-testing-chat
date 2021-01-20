package com.examples.testing.chat.domain;

import com.examples.testing.chat.application.create.ChatRegistrationRequest;

public interface ChatService {

    ChatId createChat(ChatRegistrationRequest chat);

}
