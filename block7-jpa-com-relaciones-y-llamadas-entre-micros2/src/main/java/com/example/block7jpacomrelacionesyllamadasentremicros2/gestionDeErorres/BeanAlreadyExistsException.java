package com.example.block7jpacomrelacionesyllamadasentremicros2.gestionDeErorres;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeanAlreadyExistsException extends Throwable {
    public BeanAlreadyExistsException(String message) {
        super(message);
    }
}
