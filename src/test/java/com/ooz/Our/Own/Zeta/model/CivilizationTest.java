package com.ooz.Our.Own.Zeta.model;

import static org.junit.jupiter.api.Assertions.*;

class CivilizationTest {

    @Test
    public void CivilizationStartsAtZero(){

        Civilization civilization = new Civilization();

        assertEquals(0,civilization.getAge());
        assertEquals(0,civilization.getResources());
        assertEquals(0,civilization.getDiscoveries());
        assertEquals(0,civilization.getPopulation());
        assertEquals(0,civilization.getImportantIndividuals());
        assertEquals(0,civilization.getEventsLog());
    }
}