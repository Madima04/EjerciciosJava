package com.example.block16springcloud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dto.output.ClientOutput;
import org.example.dto.output.ClientOutputSimple;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String firstSurname;
    private int age;
    private String email;
    private int phone;
    @ManyToOne
    private Trip trip;

    public ClientOutput toClientOutput() {
        ClientOutput clientOutput = new ClientOutput();
        clientOutput.setId(this.id);
        clientOutput.setName(this.name);
        clientOutput.setFirstSurname(this.firstSurname);
        clientOutput.setAge(this.age);
        clientOutput.setEmail(this.email);
        clientOutput.setPhone(this.phone);
        if (this.trip == null) {
            return clientOutput;
        }
        clientOutput.setTrip(this.trip.toTripOutputSimple());
        return clientOutput;
    }

    public ClientOutputSimple toClientOutputSimple() {
        ClientOutputSimple clientOutputSimple = new ClientOutputSimple();
        clientOutputSimple.setName(this.name);
        clientOutputSimple.setFirstSurname(this.firstSurname);
        clientOutputSimple.setAge(this.age);
        clientOutputSimple.setEmail(this.email);
        clientOutputSimple.setPhone(this.phone);
        return clientOutputSimple;
    }
}
