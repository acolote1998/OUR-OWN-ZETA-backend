package com.ooz.Our.Own.Zeta.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void personStartsAtZero() {
        Person person = new Person();

        assertEquals(0, person.getAge());
        assertEquals("", person.getName());
        assertEquals("", person.getField());
        assertTrue(person.getDiscoveries().isEmpty(), "Discoveries is not empty");
        assertTrue(person.isAlive(), "Person is not alive");
        assertEquals(0, person.getKnowledge());
    }

    @Test
    public void passing20Years() {
        Person person = new Person();
        person.passManyYears(20);
        assertEquals(20, person.getAge());
    }

    @Test
    public void passingAwayWith100Years() {
        Person person = new Person();
        person.passManyYears(100);
        assertEquals(100, person.getAge());
        assertFalse(person.isAlive());
        assertFalse(person.getLifeLog().isEmpty());
        System.out.println(person.getLifeLog());
    }

}