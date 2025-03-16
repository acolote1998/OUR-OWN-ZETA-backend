package com.ooz.Our.Own.Zeta.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CivilizationTest {

    @Test
    public void civilizationStartsAtZero() {

        Civilization civilization = new Civilization();

        assertEquals(0, civilization.getAge());
        assertTrue(civilization.getResources().isEmpty(), "Resources is not empty");
        assertTrue(civilization.getDiscoveries().isEmpty(), "Discoveries is not empty");
        assertEquals(0, civilization.getPopulation());
        assertTrue(civilization.getImportantIndividuals().isEmpty(), "Individuals is not empty");
        assertTrue(civilization.getEventsLog().isEmpty(), "EventLogs is not empty");
        assertEquals(8, civilization.getLanguagePatterns().size());//VowelsPerWord,ConsonantsPerWord,VowelClusterRate,XYZRate, HRate
        assertEquals(0.0, civilization.getLanguagePatterns().get("VowelsPerWord"));
        assertEquals(0.0, civilization.getLanguagePatterns().get("ConsonantsPerWord"));
        assertEquals(0.0, civilization.getLanguagePatterns().get("VowelClusterRate"));
        assertEquals(0.0, civilization.getLanguagePatterns().get("ConsonantClusterRate"));
        assertEquals(0.0, civilization.getLanguagePatterns().get("XYZRate"));
        assertEquals(0.0, civilization.getLanguagePatterns().get("HRate"));
        assertEquals(0.0, civilization.getLanguagePatterns().get("KRate"));
        assertEquals(0.0, civilization.getLanguagePatterns().get("RRRate"));


    }

    @Test
    public void civilizationAging5years() {
        Civilization civilization = new Civilization();
        civilization.passTime(5); //passing 5 years
        assertEquals(5, civilization.getAge());
    }

    @Test
    public void creatingAScientist() {
        Civilization civilization = new Civilization();
        Person scientist = civilization.createImportantPerson(20, "Aki", "Scientist", null, true, 0);
        assertEquals(20, scientist.getAge());
        assertEquals("Aki", scientist.getName());
        assertEquals("Scientist", scientist.getField());
        assertTrue(scientist.getDiscoveries().isEmpty(), "Discoveries are not empty");
        assertTrue(scientist.isAlive(), "Person is not alive");
        assertEquals(0, scientist.getKnowledge());
    }

    @Test
    public void creatingAnArtist() {
        Civilization civilization = new Civilization();
        Person artist = civilization.createImportantPerson(20, "Aki", "Artist", null, true, 0);
        assertEquals(20, artist.getAge());
        assertEquals("Aki", artist.getName());
        assertEquals("Artist", artist.getField());
        assertTrue(artist.getDiscoveries().isEmpty(), "Discoveries are not empty");
        assertTrue(artist.isAlive(), "Person is not alive");
        assertEquals(0, artist.getKnowledge());
    }

    @Test
    public void creatingAnAthlete() {
        Civilization civilization = new Civilization();
        Person athlete = civilization.createImportantPerson(20, "Aki", "Athlete", null, true, 0);
        assertEquals(20, athlete.getAge());
        assertEquals("Aki", athlete.getName());
        assertEquals("Athlete", athlete.getField());
        assertTrue(athlete.getDiscoveries().isEmpty(), "Discoveries are not empty");
        assertTrue(athlete.isAlive(), "Person is not alive");
        assertEquals(0, athlete.getKnowledge());
    }

    @Test
    public void creatingADoctor() {
        Civilization civilization = new Civilization();
        Person doctor = civilization.createImportantPerson(20, "Aki", "Doctor", null, true, 0);
        assertEquals(20, doctor.getAge());
        assertEquals("Aki", doctor.getName());
        assertEquals("Doctor", doctor.getField());
        assertTrue(doctor.getDiscoveries().isEmpty(), "Discoveries are not empty");
        assertTrue(doctor.isAlive(), "Person is not alive");
        assertEquals(0, doctor.getKnowledge());
    }

    @Test
    public void checkingVowelsAvgInWordHola() {
        Civilization civilization = new Civilization();
        assertEquals(2.0, civilization.calculateVowelsAvgInWords("hola"), 0.01);
    }

    @Test
    public void checkingVowelsAvgInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(2.5, civilization.calculateVowelsAvgInWords("hola", "adios"), 0.01);
    }

    @Test
    public void checkingVowelsAvgInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(1.8, civilization.calculateVowelsAvgInWords("one", "two", "three", "four", "five"));
    }

    @Test
    public void checkingConsonantsAvgInOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(2, civilization.calculateConsonantsAvgInWords("hola"));
    }

    @Test
    public void checkingConsonantsAvgInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(4.5, civilization.calculateConsonantsAvgInWords("hola", "butterfly"));
    }

    @Test
    public void checkingConsonantsAvgInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(4.4, civilization.calculateConsonantsAvgInWords("hola", "butterfly", "argentum", "online", "twitch"));
    }

    @Test
    public void checkIfWordContainsVowelCluster() {
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordContainsVowelCluster("Aeris"), "Not containing vowel cluster");
    }

    @Test
    public void checkingVowelClusterRateForOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100.00, civilization.calculateVowelClusterRateInWords("Aeris"), 0.01);
    }

    @Test
    public void checkingVowelClusterRateForTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50.00, civilization.calculateVowelClusterRateInWords("Aeris", "Aki"), 0.01);
    }

    @Test
    public void checkingVowelClusterRateForFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(60.00, civilization.calculateVowelClusterRateInWords("Aeris", "Aki", "Paella", "Man", "Theodor"), 0.01);
    }

    @Test
    public void checkXYZContainedInOneWord() {
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordContainsXYZ("Zaphire"), "Word does not contain Z");
    }

    @Test
    public void checkXYZRateInOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100.0, civilization.calculateXYZRateInWords("Yemen"), 0.01);
    }

    @Test
    public void checkXYZRateInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50.0, civilization.calculateXYZRateInWords("Yemen", "Aki"), 0.01);
    }

    @Test
    public void checkXYZRateInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(40.0, civilization.calculateXYZRateInWords("Xatu", "Maunuel", "Rodrigo", "Pablo", "Alexandria"), 0.01);
    }

    @Test
    public void checkHContainedInOneWord() {
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordContainsH("Harry"), "Word does not contain H");
    }

    @Test
    public void checkHRateInOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100.0, civilization.calculateHRateInWords("Honey"), 0.01);
    }

    @Test
    public void checkHRateInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50.0, civilization.calculateHRateInWords("Aki", "Home"), 0.01);
    }

    @Test
    public void checkHRateInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(20.0, civilization.calculateHRateInWords("Ceverus", "Harry", "Snape", "Dumbledore", "Sorry"), 0.01);
    }

    @Test
    public void checkKRateInOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100.0, civilization.calculateKRateInWords("Khalid"), 0.01);
    }

    @Test
    public void checkKRateInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50.0, civilization.calculateKRateInWords("Khalid", "Sandra"), 0.01);

    }

    @Test
    public void checkKRateInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(60.0, civilization.calculateKRateInWords("Khalid", "Sandra", "Kun", "Kamilla", "Arroz"), 0.01);

    }

    @Test
    public void checkRRRateInOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100.0, civilization.calculateRRRateInWords("Arroz"), 0.01);
    }

    @Test
    public void checkRRRateInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50.0, civilization.calculateRRRateInWords("Amarrar", "Pero"), 0.01);
    }

    @Test
    public void checkRRRateInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(25.0, civilization.calculateRRRateInWords("Pez", "Perro", "Cama", "Arbol"), 0.01);
    }

    @Test
    public void checkIfWordContainsConsonantCluster() {
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordContainsConsonantCluster("Pentar"), "Does not contain consonant cluster");

    }

    @Test
    public void checkConsonantClusterRateInOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100.0, civilization.calculateConsonantClusterRateInWords("Manco"), 0.01);
    }

    @Test
    public void checkConsonantClusterRateInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50.0, civilization.calculateConsonantClusterRateInWords("Manco", "Aki"), 0.01);

    }

    @Test
    public void checkConsonantClusterRateInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(60.0, civilization.calculateConsonantClusterRateInWords("Manco", "Aki", "Michaela", "Juan", "Ptak"), 0.01);

    }

    @Test
    public void checkIfWordStatsWithVowel() {
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordStartsWithVowel("Aragorn"), "It does not start with a vowel");
    }

    @Test
    public void checkVowelStartRateForOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100.0, civilization.calculateVowelStartingRate("Aragorn"), 0.01);
    }

    @Test
    public void checkVowelStartRateForTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50.0, civilization.calculateVowelStartingRate("Gimli", "Aragorn"), 0.01);
    }

    @Test
    public void checkVowelStartRateForFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(50.0, civilization.calculateVowelStartingRate("Gimli", "Aragorn", "Legolas", "Aramir"), 0.01);
    }

    @Test
    public void checkIfWordStatsWithConsonant() {
        Civilization civilization = new Civilization();
        assertFalse(civilization.checkIfWordStartsWithVowel("Legolas"), "It does not start with a consonant");
    }
}