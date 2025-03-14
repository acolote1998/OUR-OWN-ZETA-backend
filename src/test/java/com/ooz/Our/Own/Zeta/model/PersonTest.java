package com.ooz.Our.Own.Zeta.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void personStartsAtZero(){
        Person person = new Person();

        assertEquals(0,person.getAge());
        assertEquals("",person.getName());
        assertEquals("",person.getField());
        assertTrue(person.getDiscoveries().isEmpty(),"Discoveries is not empty");
        assertTrue(person.getAlive(),"Person is not alive");
        assertEquals(0,person.getKnowledge());
    }

}