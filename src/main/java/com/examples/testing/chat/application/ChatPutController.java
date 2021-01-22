package com.examples.testing.chat.application;

import com.examples.testing.chat.application.create.ChatCreator;
import com.examples.testing.chat.application.create.ChatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ChatPutController {

    private final ChatCreator chatCreator;

    @Autowired
    public ChatPutController(ChatCreator chatCreator){
        this.chatCreator = chatCreator;
    }

    @PutMapping(value = "/chats")
    public ResponseEntity<String> createChat(@RequestBody ChatRequest request) {

        chatCreator.createChat(request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}
