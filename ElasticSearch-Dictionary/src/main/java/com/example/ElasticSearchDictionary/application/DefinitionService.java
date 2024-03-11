package com.example.ElasticSearchDictionary.application;


import com.example.ElasticSearchDictionary.controller.input.DefinitionInput;
import com.example.ElasticSearchDictionary.controller.output.DefinitionOutput;

import java.util.List;

public interface DefinitionService {
    public DefinitionOutput saveDictionary(DefinitionInput dictionary);
    public List<DefinitionOutput> getAllDictionary();
    public List<DefinitionOutput> getDictionaryById(String id);
    public void deleteDictionaryById(String id);
    public DefinitionOutput updateDictionary(DefinitionInput dictionary, String id);
    void deleteAllDictionary();
}
