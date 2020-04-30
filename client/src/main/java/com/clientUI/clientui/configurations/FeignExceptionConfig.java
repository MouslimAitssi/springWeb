package com.clientUI.clientui.configurations;


import com.clientUI.clientui.exceptions.StatusDecoder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignExceptionConfig {

    public StatusDecoder statusDecoder() {
        return new StatusDecoder();
    }

}
