package com.example.BlockAsync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Component
public class ProgressGenerator {

    @Autowired
    private ProgressController progressController;

    @Async
    public CompletableFuture<String> asyncGenerateProgress(String requestId, String name) {
        CompletableFuture<String> future = new CompletableFuture<>();
        try {
            int i = (int) (Math.random() * 50);
            for (int e = 0; e < i; e++) {
                Thread.sleep(1000);
                progressController.updateProgress(requestId, e * 100 / i);
            }
            progressController.updateProgress(requestId, 100);
            progressController.sendGreeting(requestId, name);
            future.complete("Hola " + name);
        } catch (InterruptedException e) {
            future.completeExceptionally(e);
        }
        return future;
    }
}

