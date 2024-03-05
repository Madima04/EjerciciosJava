package com.example.block16springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private int id;
    private String name;
    private String firstSurname;
    private int age;
    private String email;
    private int phone;
}
