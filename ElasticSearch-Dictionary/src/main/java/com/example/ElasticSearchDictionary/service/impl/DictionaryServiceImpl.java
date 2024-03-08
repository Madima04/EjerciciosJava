package com.example.ElasticSearchDictionary.service.impl;

import com.example.ElasticSearchDictionary.controller.dto.input.DictionaryInput;
import com.example.ElasticSearchDictionary.controller.dto.output.DictionaryOutput;
import com.example.ElasticSearchDictionary.entity.Dictionary;
import com.example.ElasticSearchDictionary.repo.DictionaryRepo;
import com.example.ElasticSearchDictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryRepo dictionaryRepo;

    @Override
    public Iterable<DictionaryOutput> saveDictionary(DictionaryInput dictionary) {
        Dictionary newDictionary = new Dictionary(dictionary);
        dictionaryRepo.save(newDictionary);
        return newDictionary.toOutput();
    }

    @Override
    public Iterable<DictionaryOutput> getAllDictionary() {
        Iterable<DictionaryOutput> output = new HashSet<>();
        for (Dictionary dictionary : dictionaryRepo.findAll()) {
            output = dictionary.toOutput();
        }
        return output;
    }

    @Override
    public Iterable<DictionaryOutput> getDictionaryById(int id) {
        return dictionaryRepo.findById(id).get().toOutput();
    }

    @Override
    public void deleteDictionaryById(int id) {
        dictionaryRepo.deleteById(id);
    }

    @Override
    public Iterable<DictionaryOutput> updateDictionary(DictionaryInput dictionary, int id) {
        Dictionary updatedDictionary = new Dictionary(dictionary);
        updatedDictionary.setId(id);
        dictionaryRepo.save(updatedDictionary);
        return updatedDictionary.toOutput();
    }
}
