package com.example.ElasticSearchDictionary.repo;

import com.example.ElasticSearchDictionary.entity.Dictionary;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DictionaryRepo extends ElasticsearchRepository<Dictionary, Integer> {
}
