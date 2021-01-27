package com.examples.testing.chat.application.search;

import com.examples.testing.chat.domain.Chat;
import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.chat.domain.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public final class ChatFinder {

    private final ChatRepository chatRepository;

    public ChatFinder(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Map<ChatId,Chat> find(){
        return chatRepository.find();
    }

    public Optional<Chat> findById(ChatId chatId){
        return chatRepository.findById(chatId);
    }
}
