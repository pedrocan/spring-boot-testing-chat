package com.examples.testing.chat.application.search;

import com.examples.testing.chat.domain.Chat;
import com.examples.testing.chat.domain.ChatId;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public final class ChatGetController {

    private ChatFinder chatFinder;

    public ChatGetController(ChatFinder chatFinder) {
        this.chatFinder = chatFinder;
    }

    @GetMapping("/chats")
    public Map<ChatId,Chat> getAll() {
       return chatFinder.find();
    }

    @GetMapping("/chats/{id}")
    public Optional<Chat> getById(@PathVariable String chatId) {
        return chatFinder.findById(new ChatId(chatId));
    }
}
