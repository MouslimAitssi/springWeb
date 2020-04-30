package com.clientUI.clientui.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class StatusDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        ErrorDecoder defaultErrorDecoder = new Default();
        if(response.status() == 404) {
            return new JeuIntrouvableException("Le jeu que vous avez spécifié est introuvable.");
        }
        return defaultErrorDecoder.decode(s, response);
    }

}