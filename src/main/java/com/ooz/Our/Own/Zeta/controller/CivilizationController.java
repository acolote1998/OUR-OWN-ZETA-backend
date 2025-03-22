package com.ooz.Our.Own.Zeta.controller;

import com.ooz.Our.Own.Zeta.model.Civilization;
import com.ooz.Our.Own.Zeta.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/civilizations")
public class CivilizationController {

    private final Map<String, Civilization> civilizations = new HashMap<>();

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

    // Creating Civilization
    // POST http://localhost:8080/civlizations
    @PostMapping
    public Civilization createCivilization(@RequestBody CivilizationDto civilizationDto) {

        Civilization civilizationObject = civilizationDto.createCivilization();
        if (!civilizationObject.getName().isBlank()) {
            civilizations.put(civilizationObject.getName(), civilizationObject);
        }
        return civilizationObject;
    }


}