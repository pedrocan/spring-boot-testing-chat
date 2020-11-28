package com.examples.testing.chat.domain;

import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<Chat, ChatId> {
}
