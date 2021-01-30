package com.examples.testing.chat.application.create;

import com.examples.testing.chat.application.create.request.ChatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ChatPutController {

    private final ChatCreator chatCreator;

    @Autowired
    public ChatPutController(ChatCreator chatCreator) {
        this.chatCreator = chatCreator;
    }

    @PutMapping(value = "/chats")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createChat(@RequestBody ChatDTO request) {
        return new ResponseEntity<>(chatCreator.createChat(request).value(), HttpStatus.CREATED);
    }


}
