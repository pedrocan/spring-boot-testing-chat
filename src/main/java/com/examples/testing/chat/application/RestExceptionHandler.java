package com.examples.testing.chat.application;

import com.examples.testing.chat.application.search.ChatNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public final class RestExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler({ ChatNotFoundException.class })
        protected ResponseEntity<Object> handleNotFound(
                Exception ex, WebRequest request) {
            return handleExceptionInternal(ex, "Chat not found",
                    new HttpHeaders(), HttpStatus.NOT_FOUND, request);
        }

}
