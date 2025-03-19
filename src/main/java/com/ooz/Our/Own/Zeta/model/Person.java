package com.ooz.Our.Own.Zeta.model;

import java.util.*;

public class Person {
    int age;
    String name;
    String field;
    Map<String, Integer> discoveries = new HashMap<>();//<Name of Discovery, Tier>
    boolean alive;
    int knowledge;
    private List<String> lifeLog = new ArrayList<>();

    public List<String> getLifeLog() {
        return lifeLog;
    }

    public void setLifeLog(List<String> lifeLog) {
        this.lifeLog = lifeLog;
    }

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

    public void passManyYears(int years) {
        for (int i = 0; i < years; i++) {
            pasOneYear();
        }
    }

    public void pasOneYear() {
        this.age += 1;
        Random random = new Random();
        if (age >= 100) {
            passAway();
        } else if (age > 90) {
            if (random.nextInt(1, 101) <= 70) {
                passAway();
            }
        } else if (age > 80) {
            if (random.nextInt(1, 101) <= 60) {
                passAway();
            }
        } else if (age > 70) {
            if (random.nextInt(1, 101) <= 50) {
                passAway();
            }
        } else if (age > 60) {
            if (random.nextInt(1, 101) <= 10) {
                passAway();
            }
        } else if (age > 40) {
            if (random.nextInt(1, 101) <= 3) {
                passAway();
            }
        } else if (age > 20) {
            if (random.nextInt(1, 101) <= 1) {
                passAway();
            }
        }

    }

    public String passAway() {
        this.alive = false;
        String message = name + " has passed away at the age of " + age;
        lifeLog.add(message);
        return message;
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