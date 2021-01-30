package com.examples.testing.chat.application.search;

import com.examples.testing.chat.application.create.request.ChatDTO;
import com.examples.testing.chat.domain.ChatId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class ChatGetController {

    private ChatFinder chatFinder;

    public ChatGetController(ChatFinder chatFinder) {
        this.chatFinder = chatFinder;
    }

    @GetMapping("/chats")
    public List<ChatDTO> getAll() {
        return chatFinder.find();
    }

    @GetMapping("/chats/{id}")
    public ChatDTO getById(@PathVariable("id") String chatId) {
        return chatFinder.findById(new ChatId(chatId));
    }
}
