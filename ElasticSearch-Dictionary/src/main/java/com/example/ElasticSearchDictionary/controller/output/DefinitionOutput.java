package com.example.ElasticSearchDictionary.controller.output;

import lombok.Data;

@Data
public class DefinitionOutput {
    private String name;
    private String description;

    public DefinitionOutput(String word, String meaning) {
        this.name = word;
        this.description = meaning;
    }
}
