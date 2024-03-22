package org.example.dto.output;

import lombok.Data;

@Data
public class ClientOutput {
    private int id;
    private String name;
    private String firstSurname;
    private int age;
    private String email;
    private int phone;
    private TripOutputSimple trip;

}
