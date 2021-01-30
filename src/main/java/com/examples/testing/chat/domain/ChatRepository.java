package com.examples.testing.chat.domain;


import java.util.Map;
import java.util.Optional;

public interface ChatRepository {

    ChatId save(Chat chat);

    Optional<Chat> findById(ChatId chatId);

    Map<ChatId, Chat> find();
}
