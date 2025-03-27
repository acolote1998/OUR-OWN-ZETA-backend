package com.ooz.Our.Own.Zeta.controller;

import com.ooz.Our.Own.Zeta.model.Civilization;
import com.ooz.Our.Own.Zeta.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

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
        Civilization civilization = null;
        if (civilizations.get(name) != null) {
            civilization = civilizations.get(name);
        } else {
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

    // Obtaining the history log
    // GET http://localhost:8080/civilizations/{name}/getHistoryLog
    @GetMapping("/{name}/getHistoryLog")
    public List<String> getHistoryLog(@PathVariable String name) {
        List<String> eventsLog = new ArrayList<>();
        if (!civilizations.get(name).getName().isEmpty()) {
            eventsLog = civilizations.get(name).getEventsLog();
        } else {
            throw new RuntimeException("Civilization not found");
        }
        return eventsLog;
    }

    // Learning a new resource
    // POST http://localhost:8080/civilizations/name/learnResource
    @PostMapping("/{name}/learnResource")
    public String learnResource(@PathVariable String name, @RequestBody Integer chancesOfLearningResource) {
        String answer = "";
        if (!civilizations.get(name).getName().isEmpty()) {
            answer = civilizations.get(name).learningResource(chancesOfLearningResource);
        } else {
            answer = "Civilization not found";
        }
        return answer;
    }

    //Discovering something
    // POST http://localhost:8080/civlizations/{name}/discoverSomething
    @PostMapping("/{name}/discoverSomething")
    public String discoverSomething(@PathVariable String name, @RequestBody Integer chancesOfDiscoveringSomething) {
        String answer = "";
        if (!civilizations.get(name).getName().isEmpty()) {
            answer = civilizations.get(name).discoverSomething(chancesOfDiscoveringSomething);
        } else {
            answer = "Civilization not found";
        }
        return answer;
    }

    // Creating Civilization
    // POST http://localhost:8080/civlizations
    @PostMapping
    public Civilization createCivilization() {
        Civilization civilization = new Civilization(
        );
        civilization.setName(civilizationNameGenerator.generateName());
        if (!civilization.getName().isBlank()) {
            civilizations.put(civilization.getName(), civilization);
            civilizations.get(civilization.getName()).setLanguagePatterns(civilizationNameGenerator.getLanguagePatterns());
        }

        return civilization;
    }

    // Feeding Name Patterns
    // POST http://localhost:8000/civilizations/feedingLanguagePatterns
    @PostMapping("/feedingLanguagePatterns")
    public Map<String, Integer> feedNamePatterns(@RequestBody String... others) {
        civilizationNameGenerator.feedLanguagePattern(others);
        return civilizationNameGenerator.getLanguagePatterns();
    }

    //Aging the civlization
    //POST http://localhost:8080/civilizations/{name}/ageCivilization/{years}
    @PostMapping("/{name}/ageCivilization")
    public String ageCivilization(@PathVariable String name, @RequestBody Integer yearsToPass) {
        String answer = "";
        if (!civilizations.get(name).getName().isEmpty()) {
            civilizations.get(name).passTime(yearsToPass);
            answer = yearsToPass + " years have passed";
        } else {
            answer = "Civilization not found";
        }
        return answer;
    }

    //Creating a special person
    //POST http://localhost:8080/civilizations/{name}/createSpecialPerson
    @PostMapping("/{name}/createSpecialPerson")
    public String createSpecialPerson(@PathVariable String name) {
        String answer = "";
        if (!civilizations.get(name).getName().isEmpty()) {
            answer = civilizations.get(name).createRandomPerson();
        } else {
            return "Civilization not found.";
        }
        return answer;
    }
}