package com.examples.testing.chat.infrastructure.persistence;

import com.examples.testing.chat.domain.Chat;
import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.chat.domain.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public final class InMemoryChatRepository implements ChatRepository {

    private final Map<ChatId, Chat> chats = new HashMap<>();

    @Override
    public ChatId save(Chat chat) {

        chats.put(chat.id(), chat);
        return chat.id();
    }

    @Override
    public Optional<Chat> findById(ChatId chatId) {
        return Optional.ofNullable(chats.get(chatId));
    }

    @Override
    public Map<ChatId, Chat> find() {
        return chats;
    }


}
