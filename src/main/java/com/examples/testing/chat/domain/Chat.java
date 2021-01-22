package com.examples.testing.chat.domain;

import java.util.Objects;

public final class Chat {

    private final ChatId id;
    private final String name;

    public Chat(ChatId id, String name) {

        if(id == null || id.value().isBlank() || id.value().isEmpty()){
            throw new IllegalArgumentException("Invalid ID");
        }
        if(name == null || name.isBlank() || name.isEmpty()){
            throw new IllegalArgumentException("Invalid name");
        }

        this.id = id;
        this.name = name;
    }

    public ChatId id() {
        return id;
    }

    public String name() {
        return name;
    }


    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id.value() +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return id.value().equals(chat.id.value()) &&
                name.equals(chat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id.value(), name);
    }
}
