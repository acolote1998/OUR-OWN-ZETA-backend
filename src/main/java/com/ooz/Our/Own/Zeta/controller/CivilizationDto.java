package com.ooz.Our.Own.Zeta.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ooz.Our.Own.Zeta.model.Civilization;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CivilizationDto(String name) {
    public Civilization createCivilization() {

        Civilization civilization = new Civilization();
        civilization.setName(name);

        return civilization;
    }
}