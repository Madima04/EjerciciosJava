package org.springframework.ai.openai.samples.helloworld.openai;

import lombok.*;
import jakarta.persistence.*;


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

