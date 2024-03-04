package com.example.BlockAsync.controller;

import com.example.BlockAsync.dto.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin("*")
public class HolaController {

    @Autowired
    private ProgressService progressGenerator;

    @Autowired
    private ProgressController progressController;

    @RequestMapping("/hola/{name}")
    public String hola(@PathVariable String name) {
        String requestId = UUID.randomUUID().toString();
        CompletableFuture<Mensaje> future = progressGenerator.asyncGenerateProgress(requestId, name);
        return requestId;
    }

    @GetMapping("/progress/{requestId}")
    public SseEmitter progress(@PathVariable String requestId) {
        return progressController.registerProgressEmitter(requestId);
    }
}
