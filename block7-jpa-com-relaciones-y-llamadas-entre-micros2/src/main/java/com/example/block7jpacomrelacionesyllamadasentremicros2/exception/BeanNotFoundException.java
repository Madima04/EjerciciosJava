package com.example.block7jpacomrelacionesyllamadasentremicros2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeanNotFoundException  extends RuntimeException {
    public BeanNotFoundException(String message) {
        super(message);
    }
}
