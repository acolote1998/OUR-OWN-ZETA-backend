package com.ooz.Our.Own.Zeta.controller;

import com.ooz.Our.Own.Zeta.model.Civilization;
import com.ooz.Our.Own.Zeta.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/civilizations")
public class CivilizationController {

    private final Map<String, Civilization> civilizations = new HashMap<>();
    private final Civilization civilizationNameGenerator = new Civilization();

    // Initializing some civilizations in the future maybe
    public CivilizationController() {
    }

    // Obtaining civilization by name
    // GET http://localhost:8080/civlizations/name
    @GetMapping(value = "/{name}", produces = "application/json")
    public Civilization getCivilization(@PathVariable String name) {
        Civilization civilization = civilizations.get(name);
        if (civilization == null) {
            throw new RuntimeException("Civilization not found");
        }
        return civilization;
    }

    // Obtaining all civilizations
    // GET http://localhost:8080/civilizations/getAll
    @GetMapping("/getAll")
    public Map<String, Civilization> getAllCivilizations() {
        return civilizations;
    }

    // Creating Civilization
    // POST http://localhost:8080/civlizations
    @PostMapping
    public CivilizationDto createCivilization() {
        CivilizationDto civilizationDto = new CivilizationDto(civilizationNameGenerator.generateName());
        Civilization civilizationObject = civilizationDto.createCivilization();
        if (!civilizationDto.name().isBlank()) {
            civilizations.put(civilizationObject.getName(), civilizationObject);
        }
        return civilizationDto;
    }

    // Feeding Name Patterns
    // POST http://localhost:8000/civilizations/feedingLanguagePatterns
    @PostMapping("/feedingLanguagePatterns")
    public Map<String, Integer> feedNamePatterns(@RequestBody String... others) {
        civilizationNameGenerator.feedLanguagePattern(others);
        return civilizationNameGenerator.getLanguagePatterns();
    }


}