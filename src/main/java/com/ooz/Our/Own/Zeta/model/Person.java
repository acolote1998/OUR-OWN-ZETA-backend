package com.ooz.Our.Own.Zeta.model;

import java.util.HashMap;
import java.util.Map;

public class Person {
    int age;
    String name;
    String field;
    Map<String, Integer> discoveries = new HashMap<>();//<Name of Discovery, Tier>
    boolean alive;
    int knowledge;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Map<String, Integer> getDiscoveries() {
        return discoveries;
    }

    public void setDiscoveries(Map<String, Integer> discoveries) {
        this.discoveries = discoveries;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public Person() {
        this.age = 0;
        this.name = "";
        this.field = "";
        this.discoveries = new HashMap<>();
        this.alive = true;
        this.knowledge = 0;
    }


    public void passYears(int years) {
        this.age += years;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", field='" + field + '\'' +
                ", discoveries=" + discoveries +
                ", alive=" + alive +
                ", knowledge=" + knowledge +
                '}';
    }
}