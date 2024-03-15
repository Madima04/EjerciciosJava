package com.example.AIDatabase.configuration.openai;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userInput;
    private String aiResponse;

    public Conversation(String userInput, String aiResponse) {
        this.userInput = userInput;
        this.aiResponse = aiResponse;
    }
}

