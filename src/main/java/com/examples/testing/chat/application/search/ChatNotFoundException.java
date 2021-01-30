package com.examples.testing.chat.application.search;

public final class ChatNotFoundException extends RuntimeException {

    public ChatNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChatNotFoundException() {
    }
}
