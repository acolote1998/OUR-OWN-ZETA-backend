package com.ooz.Our.Own.Zeta.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CivilizationTest {

    @Test
    public void civilizationStartsAtZero(){

        Civilization civilization = new Civilization();

        assertEquals(0,civilization.getAge());
        assertTrue(civilization.getResources().isEmpty(),"Resources is not empty");
        assertTrue(civilization.getDiscoveries().isEmpty(),"Discoveries is not empty");
        assertEquals(0,civilization.getPopulation());
        assertTrue(civilization.getImportantIndividuals().isEmpty(),"Individuals is not empty");
        assertTrue(civilization.getEventsLog().isEmpty(),"EventLogs is not empty");
        assertEquals(5,civilization.getLanguagePatterns().size());//VowelsPerWord,ConsonantsPerWord,VowelClusterRate,XYZRate, HRate
        assertEquals(0.0,civilization.getLanguagePatterns().get("VowelsPerWord"));
        assertEquals(0.0,civilization.getLanguagePatterns().get("ConsonantsPerWord"));
        assertEquals(0.0,civilization.getLanguagePatterns().get("VowelClusterRate"));
        assertEquals(0.0,civilization.getLanguagePatterns().get("XYZRate"));
        assertEquals(0.0,civilization.getLanguagePatterns().get("HRate"));

    }

    @Test
    public void civilizationAging5years(){
        Civilization civilization = new Civilization();
        civilization.passTime(5); //passing 5 years
        assertEquals(5,civilization.getAge());
    }

    @Test
    public void creatingAScientist(){
        Civilization civilization = new Civilization();
        Person scientist = civilization.createImportantPerson(20,"Aki","Scientist",null,true,0);
        assertEquals(20,scientist.getAge());
        assertEquals("Aki",scientist.getName());
        assertEquals("Scientist",scientist.getField());
        assertTrue(scientist.getDiscoveries().isEmpty(),"Discoveries are not empty");
        assertTrue(scientist.isAlive(),"Person is not alive");
        assertEquals(0,scientist.getKnowledge());
    }

    @Test
    public void creatingAnArtist(){
        Civilization civilization = new Civilization();
        Person artist = civilization.createImportantPerson(20,"Aki","Artist",null,true,0);
        assertEquals(20,artist.getAge());
        assertEquals("Aki",artist.getName());
        assertEquals("Artist",artist.getField());
        assertTrue(artist.getDiscoveries().isEmpty(),"Discoveries are not empty");
        assertTrue(artist.isAlive(),"Person is not alive");
        assertEquals(0,artist.getKnowledge());
    }

    @Test
    public void creatingAnAthlete(){
        Civilization civilization = new Civilization();
        Person athlete = civilization.createImportantPerson(20,"Aki","Athlete",null,true,0);
        assertEquals(20,athlete.getAge());
        assertEquals("Aki",athlete.getName());
        assertEquals("Athlete",athlete.getField());
        assertTrue(athlete.getDiscoveries().isEmpty(),"Discoveries are not empty");
        assertTrue(athlete.isAlive(),"Person is not alive");
        assertEquals(0,athlete.getKnowledge());
    }
    @Test
    public void creatingADoctor(){
        Civilization civilization = new Civilization();
        Person doctor = civilization.createImportantPerson(20,"Aki","Doctor",null,true,0);
        assertEquals(20,doctor.getAge());
        assertEquals("Aki",doctor.getName());
        assertEquals("Doctor",doctor.getField());
        assertTrue(doctor.getDiscoveries().isEmpty(),"Discoveries are not empty");
        assertTrue(doctor.isAlive(),"Person is not alive");
        assertEquals(0,doctor.getKnowledge());
    }

    @Test
    public void checkingVowelsAvgInWordHola(){
        Civilization civilization = new Civilization();
        assertEquals(2.0,civilization.calculateVowelsAvgInWords("hola"),0.01);
    }

    @Test
    public void checkingVowelsAvgInTwoWords(){
        Civilization civilization = new Civilization();
        assertEquals(2.5,civilization.calculateVowelsAvgInWords("hola","adios"),0.01);
    }

    @Test
    public void checkingVowelsAvgInFiveWords(){
        Civilization civilization = new Civilization();
        assertEquals(1.8,civilization.calculateVowelsAvgInWords("one","two","three","four","five"));
    }

    @Test
    public void checkingConsonantsAvgInOneWord(){
        Civilization civilization = new Civilization();
        assertEquals(2,civilization.calculateConsonantsAvgInWords("hola"));
    }

    @Test
    public void checkingConsonantsAvgInTwoWords(){
        Civilization civilization = new Civilization();
        assertEquals(4.5,civilization.calculateConsonantsAvgInWords("hola","butterfly"));
    }

    @Test
    public void checkingConsonantsAvgInFiveWords(){
        Civilization civilization = new Civilization();
        assertEquals(4.4,civilization.calculateConsonantsAvgInWords("hola","butterfly","argentum","online","twitch"));
    }

    @Test
    public void checkIfWordContainsVowelCluster(){
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordContainsVowelCluster("Aeris"),"Not containing vowel cluster");
    }

    @Test
    public void checkingVowelClusterRateForOneWord(){
        Civilization civilization = new Civilization();
        assertEquals(100.00,civilization.calculateVowelClusterRateInWords("Aeris"),0.01);
    }

    @Test
    public void checkingVowelClusterRateForTwoWords(){
        Civilization civilization = new Civilization();
        assertEquals(50.00,civilization.calculateVowelClusterRateInWords("Aeris","Aki"),0.01);
    }

    @Test
    public void checkingVowelClusterRateForFiveWords(){
        Civilization civilization = new Civilization();
        assertEquals(60.00,civilization.calculateVowelClusterRateInWords("Aeris","Aki","Paella","Man","Theodor"),0.01);
    }

    @Test
    public void checkXYZContainedInOneWord(){
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordContainsXYZ("Zaphire"));
    }

    @Test
    public void checkXYZRateInOneWord(){
        Civilization civilization = new Civilization();
        assertEquals(100.0,civilization.calculateXYZRateInWords("Yemen"),0.01);
    }

    @Test
    public  void checkXYZRateInTwoWords(){
        Civilization civilization = new Civilization();
        assertEquals(50.0,civilization.calculateXYZRateInWords("Yemen","Aki"),0.01);
    }

    @Test
    public void checkXYZRateInFiveWords(){
        Civilization civilization = new Civilization();
        assertEquals(40.0,civilization.calculateXYZRateInWords("Xatu","Maunuel","Rodrigo","Pablo","Alexandria"),0.01);
    }

    @Test
    public void checkHContainedInOneWord(){
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordContainsH("Harry"),"Word does not contain H");
    }

}