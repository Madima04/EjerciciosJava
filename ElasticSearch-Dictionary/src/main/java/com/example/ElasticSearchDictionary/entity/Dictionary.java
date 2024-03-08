package com.example.ElasticSearchDictionary.entity;

import com.example.ElasticSearchDictionary.controller.dto.input.DictionaryInput;
import com.example.ElasticSearchDictionary.controller.dto.output.DictionaryOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "products")
public class Dictionary {
    private int id;
    private String name;
    private String description;

    public Dictionary(DictionaryInput dictionary) {
        this.name = dictionary.getName();
        this.description = dictionary.getDescription();
    }

    public Iterable<DictionaryOutput> toOutput() {
        DictionaryOutput output = new DictionaryOutput();
        output.setName(this.name);
        output.setDescription(this.description);
        return (Iterable<DictionaryOutput>) output;
    }
}
