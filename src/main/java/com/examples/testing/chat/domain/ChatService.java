package com.examples.testing.chat.domain;

import com.examples.testing.chat.application.create.request.ChatDTO;

public interface ChatService {

    ChatId createChat(ChatDTO chat);

}
