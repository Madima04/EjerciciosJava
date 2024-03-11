package com.example.ElasticSearchDictionary.repository;

import com.example.ElasticSearchDictionary.domain.Definition;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface DefinitionRepo extends ElasticsearchRepository<Definition, String> {

    Optional<Definition> findById(String id);

    @Query("{\"bool\": {\"should\": [{\"match\": {\"word\": \"?0\"}},{\"match\": {\"meaning\": \"?0\"}}]}}")
    Optional<List<Definition>> findByWordOrMeaning(String word);
}
