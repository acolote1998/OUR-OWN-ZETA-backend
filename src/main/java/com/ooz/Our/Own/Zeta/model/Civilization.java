package com.ooz.Our.Own.Zeta.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Civilization {

    private int age;
    private Map<String,Integer> resources = new HashMap<>(); // <Resources Name, Level>
    private Map<String,Integer> discoverments = new HashMap<>(); // <Discoverment Name, Level>
    private int population;
    private Map<Person, String> importantIndividuals = new HashMap<>(); //<Person object, Name of the person>
    private List<String> eventsLog = new ArrayList<>();

}
