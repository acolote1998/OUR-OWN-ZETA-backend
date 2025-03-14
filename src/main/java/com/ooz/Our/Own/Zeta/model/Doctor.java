package com.ooz.Our.Own.Zeta.model;

import java.util.HashMap;
import java.util.Map;

public class Doctor extends Person{
    public Doctor(int age, String name, String field, Map<String,Integer> discoveries, boolean alive, int knowledge){
        this.age=age;
        this.name=name;
        this.field=field;
        this.discoveries= new HashMap<String,Integer>();
        this.alive = alive;
        this.knowledge = knowledge;
    }
}
