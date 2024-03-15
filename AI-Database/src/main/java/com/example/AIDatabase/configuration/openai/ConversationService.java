package com.example.AIDatabase.configuration.openai;

import com.example.AIDatabase.domain.Car;
import com.example.AIDatabase.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConversationService {

    @Value("${spring.ai.openai.api-key}")
    private String openAIKey;

    @Value("${openai.api.model}")
    private String openAIModel;

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private CarRepository carRepository;

    boolean cargarBaseDeDatos = true;

    public String generateResponse(String userInput) {
        RestTemplate restTemplate = new RestTemplate();

        List<Conversation> conversations = conversationRepository.findAll();
        List<String> conversationInputs = new ArrayList<>();
        for (Conversation conversation : conversations) {
            conversationInputs.add(conversation.getUserInput());
        }

        List<Car> cars = carRepository.findAll();
        List<String> carDefinitions = new ArrayList<>();
        for (Car car : cars) {
            conversationInputs.add(car.toString());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + openAIKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", userInput + " " + String.join(" ", conversationInputs));

        List<Map<String, Object>> messages = new ArrayList<>();
        messages.add(message);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("messages", messages);
        requestBody.put("model", openAIModel);
        requestBody.put("max_tokens", 50);
        requestBody.put("temperature", 0.7);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> responseEntity = restTemplate.exchange("https://api.openai.com/v1/chat/completions", HttpMethod.POST, requestEntity, Map.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                Map<String, Object> responseBody = responseEntity.getBody();
                if (responseBody != null && responseBody.containsKey("choices")) {
                    List<Map<String, Object>> choices = (List<Map<String, Object>>) responseBody.get("choices");
                    if (!choices.isEmpty()) {
                        Map<String, Object> choice = choices.get(0);
                        if (choice.containsKey("message")) {
                            Map<String, Object> messageResponse = (Map<String, Object>) choice.get("message");
                            if (messageResponse.containsKey("content")) {
                                conversationRepository.save(new Conversation(userInput, (String) messageResponse.get("content")));
                                return (String) messageResponse.get("content");
                            }
                        }
                    }
                }
            }
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "No se pudo generar una respuesta en este momento.";
    }
}



