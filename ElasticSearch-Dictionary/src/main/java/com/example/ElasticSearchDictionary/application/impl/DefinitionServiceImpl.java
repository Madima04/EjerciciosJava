package com.example.ElasticSearchDictionary.application.impl;

import co.elastic.clients.elasticsearch._types.aggregations.Aggregation;
import com.example.ElasticSearchDictionary.application.DefinitionService;
import com.example.ElasticSearchDictionary.controller.input.DefinitionInput;
import com.example.ElasticSearchDictionary.controller.output.DefinitionOutput;
import com.example.ElasticSearchDictionary.domain.Definition;
import com.example.ElasticSearchDictionary.repository.DefinitionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.elasticsearch.core.SearchHit;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefinitionServiceImpl implements DefinitionService {

    @Autowired
    private ElasticsearchOperations operations;

    @Autowired
    private DefinitionRepo dictionaryRepo;

    @Override
    public DefinitionOutput saveDictionary(DefinitionInput dictionary) {
        Definition newDictionary = new Definition(dictionary);
        dictionaryRepo.save(newDictionary);
        return newDictionary.toOutput();
    }


    @Override
    public List<DefinitionOutput> getAllDictionary() {
        List<DefinitionOutput> output = new LinkedList<>();
        for (Definition dictionary : dictionaryRepo.findAll()) {
            output.add(dictionary.toOutput());
        }
        return output;
    }

    @Override
    public List<DefinitionOutput> getDictionaryById(String word) {
        Query query = NativeQuery.builder()
                .withQuery(q -> q
                        .multiMatch(m -> m
                                .fields("word")
                                .fields("meaning")
                                .query(word)
                        )
                )
                .build();

        SearchHits<Definition> searchHits = operations.search(query, Definition.class);
        return searchHits.getSearchHits().stream()
                .map(SearchHit::getContent)
                .map(Definition::toOutput)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDictionaryById(String id) {
        dictionaryRepo.deleteById(id);
    }

    @Override
    public DefinitionOutput updateDictionary(DefinitionInput dictionary, String id) {
        Definition updatedDictionary = new Definition(dictionary);
        updatedDictionary.setId(id);
        dictionaryRepo.save(updatedDictionary);
        return updatedDictionary.toOutput();
    }

    @Override
    public void deleteAllDictionary() {
        dictionaryRepo.deleteAll();
    }
}