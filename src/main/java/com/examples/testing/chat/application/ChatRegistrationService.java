package com.examples.testing.chat.application;

import com.examples.testing.chat.domain.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ChatRegistrationService {

    private final ChatRepository chatRepository;

    @Autowired
    public ChatRegistrationService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public void registerNewChat(ChatRegistrationRequest request){

        chatRepository.save(request.getChat());

    }
}
