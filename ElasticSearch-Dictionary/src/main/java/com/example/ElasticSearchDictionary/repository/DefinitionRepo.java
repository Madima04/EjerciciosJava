package com.example.ElasticSearchDictionary.repository;

import com.example.ElasticSearchDictionary.domain.Definition;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface DefinitionRepo extends ElasticsearchRepository<Definition, String> {

    Optional<Definition> findById(String id);

}
