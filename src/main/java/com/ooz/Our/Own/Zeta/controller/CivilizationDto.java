package com.ooz.Our.Own.Zeta.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ooz.Our.Own.Zeta.model.Civilization;
import com.ooz.Our.Own.Zeta.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CivilizationDto(String name,
                              int age,
                              Map<String, Integer> resources,
                              Map<String, Integer> discoveries,
                              int population,
                              Map<String, Person> importantIndividuals,
                              List<String> eventsLog,
                              Map<String, Integer> languagePatterns) {
    public Civilization createCivilization() {

        Civilization civilization = new Civilization();
        civilization.setName(name);
        civilization.setLanguagePatterns(languagePatterns);

        return civilization;
    }
}