package com.clientUI.clientui.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class JeuIntrouvableException extends Exception{
        public JeuIntrouvableException(String message) {
            super(message);
        }
}
