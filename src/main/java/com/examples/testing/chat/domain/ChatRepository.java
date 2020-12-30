package com.examples.testing.chat.domain;

import java.util.Optional;

public interface ChatRepository{

    ChatId save(Chat chat);

    Optional<Chat> findById(ChatId chatId);

}
