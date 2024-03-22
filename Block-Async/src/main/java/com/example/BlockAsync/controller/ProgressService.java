package com.example.BlockAsync.controller;

import com.example.BlockAsync.dto.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProgressService {

    @Autowired
    private ProgressController progressController;

    @Async
    public CompletableFuture<Mensaje> asyncGenerateProgress(String requestId, String name) {
        CompletableFuture<Mensaje> future = new CompletableFuture<>();
        try {
            int i = (int) (Math.random() * 50);
            for (int e = 0; e < i; e++) {
                Thread.sleep(1000);
                progressController.updateProgress(requestId, new Mensaje(String.valueOf(e * 100 / i), "progress"));
                if (Math.random() < 0.2){
                    progressController.updateProgress(requestId, new Mensaje(String.valueOf(e * 100 / i), "error"));
                    return future;
                }
            }
            progressController.updateProgress(requestId, new Mensaje("100", "progress"));
            progressController.sendGreeting(requestId, name);
            future.complete(new Mensaje("Hola " + name, "success"));
        } catch (InterruptedException e) {
            future.completeExceptionally(e);
        }
        return future;
    }
}
