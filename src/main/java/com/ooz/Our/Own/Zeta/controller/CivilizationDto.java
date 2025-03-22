package com.ooz.Our.Own.Zeta.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ooz.Our.Own.Zeta.model.Civilization;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CivilizationDto(String name, Map<String, Integer> languagePatterns) {
    public Civilization createCivilization() {

        Civilization civilization = new Civilization();
        civilization.setName(name);
        civilization.setLanguagePatterns(languagePatterns);

        return civilization;
    }
}