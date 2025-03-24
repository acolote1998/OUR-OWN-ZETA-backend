package com.ooz.Our.Own.Zeta.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void personStartsAtZero() {
        Person person = new Person(0, "", "", null, true, 0, null);

        assertEquals(0, person.getAge());
        assertEquals("", person.getName());
        assertEquals("", person.getField());
        assertTrue(person.getDiscoveries().isEmpty(), "Discoveries is not empty");
        assertTrue(person.isAlive(), "Person is not alive");
        assertEquals(0, person.getKnowledge());
    }

    @Test
    public void passing20Years() {
        Person person = new Person(0, "", "", null, true, 0, null);

        person.passManyYears(20);
        assertEquals(20, person.getAge());
    }

    @Test
    public void passingAwayWith100Years() {
        Person person = new Person(0, "", "", null, true, 0, null);

        person.passManyYears(100);
        // assertEquals(100, person.getAge());
        assertFalse(person.isAlive());
        assertFalse(person.getLifeLog().isEmpty());
        System.out.println(person.getLifeLog());
    }

    @Test
    public void discoveringSomething() {
        Person person = new Artist(0, "Pepe", "Artist", new HashMap<String, Integer>(), true, 0, new ArrayList<String>());
        person.discoverSomething(100);
        assertTrue(person.getKnowledge() > 0);
    }

    @Test
    public void discoveringTenThings() {
        Person person = new Artist(0, "Pepe", "Artist", new HashMap<String, Integer>(), true, 0, new ArrayList<String>());
        person.discoverSomething(100);
        person.discoverSomething(100);
        person.discoverSomething(100);
        person.discoverSomething(100);
        person.discoverSomething(100);
        person.discoverSomething(100);
        person.discoverSomething(100);
        person.discoverSomething(100);
        person.discoverSomething(100);
        person.discoverSomething(100);
        assertTrue(person.getKnowledge() > 0);
    }


}