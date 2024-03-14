package org.springframework.ai.openai.samples.helloworld.openai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

    private final ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("/generate")
    public String generateResponse(@RequestParam String userInput) {
        return conversationService.generateResponse(userInput);
    }
}

