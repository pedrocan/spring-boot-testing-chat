package com.examples.testing.chat;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ChatRepository extends CrudRepository<Chat, UUID> {
}
