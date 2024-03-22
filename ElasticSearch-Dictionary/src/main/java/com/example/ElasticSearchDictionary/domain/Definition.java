package com.example.ElasticSearchDictionary.domain;

import com.example.ElasticSearchDictionary.controller.input.DefinitionInput;
import com.example.ElasticSearchDictionary.controller.output.DefinitionOutput;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "definition")
@Entity
public class Definition {
    @Id

    private String id;
    @Field(type = FieldType.Text, name = "word")
    private String word;
    @Field(type = FieldType.Text, name = "meaning")
    private String meaning;

    public Definition(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public Definition(DefinitionInput dictionary) {
        this.word = dictionary.getName();
        this.meaning = dictionary.getDescription();
    }

public DefinitionOutput toOutput() {
        return new DefinitionOutput(this.word, this.meaning);
    }
}
