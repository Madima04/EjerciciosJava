package com.example.BlockAsync.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
class ProgressController {

    private final Map<String, SseEmitter> emitters = new HashMap<>();
    private final Map<String, String> nameMap = new HashMap<>();

    public void updateProgress(String requestId, int progress) {
        SseEmitter emitter = emitters.get(requestId);
        if (emitter != null) {
            try {
                emitter.send(progress);
            } catch (IOException e) {
                emitter.completeWithError(e);
                emitters.remove(requestId);
            }
        }
    }

    public void sendGreeting(String requestId, String name) {
        SseEmitter emitter = emitters.get(requestId);
        if (emitter != null) {
            try {
                emitter.send("Hola " + name);
            } catch (IOException e) {
                emitter.completeWithError(e);
            } finally {
                emitter.complete();
                emitters.remove(requestId);
            }
        }
    }

    public SseEmitter registerProgressEmitter(String requestId) {
        SseEmitter emitter = new SseEmitter();
        emitters.put(requestId, emitter);
        emitter.onCompletion(() -> emitters.remove(requestId));
        return emitter;
    }

    public void mapNameToRequest(String requestId, String name) {
        nameMap.put(requestId, name);
    }

    public String getNameForRequest(String requestId) {
        return nameMap.get(requestId);
    }
}





