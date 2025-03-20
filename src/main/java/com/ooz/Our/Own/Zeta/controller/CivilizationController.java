package com.ooz.Our.Own.Zeta.controller;

import com.ooz.Our.Own.Zeta.model.Civilization;
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
    @GetMapping("/{name}")
    public Civilization getCivilization(@PathVariable String name) {
        Civilization civilization = civilizations.get(name);
        if (civilization == null) {
            throw new RuntimeException("Civilization not found");
        }
        return civilization;
    }
}