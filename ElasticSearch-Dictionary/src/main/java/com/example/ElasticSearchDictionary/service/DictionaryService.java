package com.example.ElasticSearchDictionary.service;

import com.example.ElasticSearchDictionary.controller.dto.input.DictionaryInput;
import com.example.ElasticSearchDictionary.controller.dto.output.DictionaryOutput;
import com.example.ElasticSearchDictionary.entity.Dictionary;
import com.example.ElasticSearchDictionary.repo.DictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface DictionaryService {
        public Iterable<DictionaryOutput> saveDictionary(DictionaryInput dictionary);
        public Iterable<DictionaryOutput> getAllDictionary();
        public Iterable<DictionaryOutput> getDictionaryById(int id);
        public void deleteDictionaryById(int id);
        public Iterable<DictionaryOutput> updateDictionary(DictionaryInput dictionary, int id);
}
