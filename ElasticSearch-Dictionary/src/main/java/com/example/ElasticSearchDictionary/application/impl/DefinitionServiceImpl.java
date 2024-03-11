package com.example.ElasticSearchDictionary.application.impl;

import com.example.ElasticSearchDictionary.application.DefinitionService;
import com.example.ElasticSearchDictionary.controller.input.DefinitionInput;
import com.example.ElasticSearchDictionary.controller.output.DefinitionOutput;
import com.example.ElasticSearchDictionary.domain.Definition;

import com.example.ElasticSearchDictionary.repository.DefinitionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class DefinitionServiceImpl implements DefinitionService {

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
        List<DefinitionOutput> output = new ArrayList<>();
        for (Definition dictionary : dictionaryRepo.findByWordOrMeaning(word).get()) {
            output.add(dictionary.toOutput());
        }
        return output;
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