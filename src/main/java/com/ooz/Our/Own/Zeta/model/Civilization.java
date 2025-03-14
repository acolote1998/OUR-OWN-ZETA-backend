package com.ooz.Our.Own.Zeta.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Civilization {

    private int age;
    private Map<String,Integer> resources = new HashMap<>(); // <Resources Name, Level>
    private Map<String,Integer> discoveries = new HashMap<>(); // <Discoveries Name, Level>
    private int population;
    private Map<Person, String> importantIndividuals = new HashMap<>(); //<Person object, Name of the person>
    private List<String> eventsLog = new ArrayList<>();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Integer> getResources() {
        return resources;
    }

    public void setResources(Map<String, Integer> resources) {
        this.resources = resources;
    }

    public Map<String, Integer> getDiscoveries() {
        return discoveries;
    }

    public void setDiscoveries(Map<String, Integer> discoveries) {
        this.discoveries = discoveries;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Map<Person, String> getImportantIndividuals() {
        return importantIndividuals;
    }

    public void setImportantIndividuals(Map<Person, String> importantIndividuals) {
        this.importantIndividuals = importantIndividuals;
    }

    public List<String> getEventsLog() {
        return eventsLog;
    }

    public void setEventsLog(List<String> eventsLog) {
        this.eventsLog = eventsLog;
    }

    public Civilization(){
        this.age = 0;
        this.discoveries = new HashMap<>();
        this.eventsLog = new ArrayList<>();
        this.resources = new HashMap<>();
        this.population = 0;
        this.importantIndividuals= new HashMap<>();
    }

    public void passTime(int years){
        age+=years;
    }

    public Person createImportantPerson(int age, String name, String field, Map<String,Integer> discoveries, boolean alive, int knowledge){
        Person person = null;
        switch (field){
            case "Scientist":
                person = new Scientist(age,name,field,discoveries,alive,knowledge);
                break;
            case "Artist":
                person = new Artist(age,name,field,discoveries,alive,knowledge);
                break;
            case "Athlete":
                person = new Athlete(age,name,field,discoveries,alive,knowledge);
                break;
            case "Doctor":
                person = new Doctor(age,name,field,discoveries,alive,knowledge);
                break;
        }
        return person;
    }
}
