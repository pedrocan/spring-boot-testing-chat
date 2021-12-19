package com.examples.testing.chat.application.search;

import com.examples.testing.chat.application.create.request.ChatDTO;
import com.examples.testing.chat.domain.Chat;
import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.chat.domain.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class ChatFinder {

    private final ChatRepository chatRepository;

    public ChatFinder(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public List<ChatDTO> findAll() {

        return chatRepository.findAll()
                .values()
                .stream()
                .map(ChatDTO::toDTO)
                .collect(Collectors.toList());

    }

    public ChatDTO findById(ChatId chatId) {

        Optional<Chat> chat = chatRepository.findById(chatId);

        return chat.map(ChatDTO::toDTO).orElseThrow(ChatNotFoundException::new);

    }
}
