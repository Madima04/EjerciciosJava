package org.springframework.ai.openai.samples.helloworld.langchain4j;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;

import dev.langchain4j.service.AiServices;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.ai.openai.samples.helloworld.config.ApiKeys;
import org.springframework.ai.openai.samples.helloworld.config.Assistant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/ai")
@RestController
public class AIController {
	ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

	Assistant assistant = AiServices.builder(Assistant.class)
			.chatLanguageModel(OpenAiChatModel.withApiKey(ApiKeys.OPENAI_API_KEY))
			.chatMemory(chatMemory)
			.build();

	@PostMapping("/message")
	public String chat(@RequestParam String message) {
		return   assistant.chat(message);
	}

}

