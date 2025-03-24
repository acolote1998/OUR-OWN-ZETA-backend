package com.ooz.Our.Own.Zeta.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Athlete extends Person {
    public Athlete(int age, String name, String field, Map<String, Integer> discoveries, boolean alive, int knowledge, List<String> lifeLog) {
        // Llamar al constructor de la clase base (Person) para inicializar las propiedades heredadas
        super(age, name, field, discoveries, alive, knowledge, lifeLog);
    }
}
