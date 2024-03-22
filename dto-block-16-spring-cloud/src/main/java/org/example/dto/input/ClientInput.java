package org.example.dto.input;

import lombok.Data;

@Data
public class ClientInput {
    private String name;
    private String firstSurname;
    private int age;
    private String email;
    private int phone;
}
