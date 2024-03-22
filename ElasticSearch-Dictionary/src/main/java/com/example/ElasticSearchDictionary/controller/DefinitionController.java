package com.example.ElasticSearchDictionary.controller;

import com.example.ElasticSearchDictionary.application.DefinitionService;
import com.example.ElasticSearchDictionary.controller.input.DefinitionInput;
import com.example.ElasticSearchDictionary.controller.output.DefinitionOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/definition")
@RestController
public class DefinitionController {

    private final DefinitionService definitionService;

    @PutMapping("/save")
    public DefinitionOutput saveDictionary(@RequestBody DefinitionInput dictionary) {
        return definitionService.saveDictionary(dictionary);
    }

    @PutMapping("/update/{id}")
    public DefinitionOutput updateDictionary(@RequestBody DefinitionInput dictionary,@PathVariable String id) {
        return definitionService.updateDictionary(dictionary, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDictionary(@PathVariable String id) {
        definitionService.deleteDictionaryById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllDictionary() {
        definitionService.deleteAllDictionary();
    }

    @GetMapping("/get")
    public List<DefinitionOutput> getDictionary(@RequestParam String word) {
        return definitionService.getDictionaryById(word);
    }

    @GetMapping("/getAll")
    public void getAllDictionary() {
        definitionService.getAllDictionary();
    }
}
