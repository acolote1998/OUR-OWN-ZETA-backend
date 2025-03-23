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
    public CivilizationDto getCivilization(@PathVariable String name) {
        CivilizationDto civilizationDto = null;
        if (civilizations.get(name) != null) {
            civilizationDto = new CivilizationDto(civilizations.get(name).getName()
                    , civilizations.get(name).getAge()
                    , civilizations.get(name).getResources()
                    , civilizations.get(name).getDiscoveries()
                    , civilizations.get(name).getPopulation()
                    , civilizations.get(name).getImportantIndividuals()
                    , civilizations.get(name).getEventsLog()
                    , civilizations.get(name).getLanguagePatterns());


        } else {
            throw new RuntimeException("Civilization not found");
        }
        return civilizationDto;
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
        CivilizationDto civilizationDto = new CivilizationDto(
                civilizationNameGenerator.generateName()
                , civilizationNameGenerator.getAge()
                , civilizationNameGenerator.getResources()
                , civilizationNameGenerator.getDiscoveries()
                , civilizationNameGenerator.getPopulation()
                , civilizationNameGenerator.getImportantIndividuals()
                , civilizationNameGenerator.getEventsLog()
                , civilizationNameGenerator.getLanguagePatterns());
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