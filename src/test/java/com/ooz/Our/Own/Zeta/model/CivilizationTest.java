package com.ooz.Our.Own.Zeta.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CivilizationTest {

    @Test
    public void civilizationStartsAtZero() {

        Civilization civilization = new Civilization();
        assertEquals("", civilization.getName());
        assertEquals(0, civilization.getAge());
        assertEquals(0, civilization.getPopulation());
        assertTrue(civilization.getImportantIndividuals().isEmpty(), "Individuals is not empty");
        assertTrue(civilization.getEventsLog().isEmpty(), "EventLogs is not empty");
        assertEquals(12, civilization.getLanguagePatterns().size());//VowelsPerWord,ConsonantsPerWord,VowelClusterRate,XYZRate, HRate
        assertEquals(0, civilization.getLanguagePatterns().get("VowelsPerWord"));
        assertEquals(0, civilization.getLanguagePatterns().get("ConsonantsPerWord"));
        assertEquals(0, civilization.getLanguagePatterns().get("VowelClusterRate"));
        assertEquals(0, civilization.getLanguagePatterns().get("ConsonantClusterRate"));
        assertEquals(0, civilization.getLanguagePatterns().get("XYZRate"));
        assertEquals(0, civilization.getLanguagePatterns().get("HRate"));
        assertEquals(0, civilization.getLanguagePatterns().get("KRate"));
        assertEquals(0, civilization.getLanguagePatterns().get("RRRate"));
        assertEquals(0, civilization.getLanguagePatterns().get("StartsWithVowelRate"));
        assertEquals(0, civilization.getLanguagePatterns().get("StartsWithConsonantRate"));
        assertEquals(0, civilization.getLanguagePatterns().get("FinishesWithVowelRate"));
        assertEquals(0, civilization.getLanguagePatterns().get("FinishesWithConsonantRate"));
        assertEquals(0, civilization.getResources().get("Technology"));
        assertEquals(0, civilization.getResources().get("Culture"));
        assertEquals(0, civilization.getResources().get("Faith"));
        assertEquals(0, civilization.getResources().get("Raw Materials"));
        assertEquals(0, civilization.getResources().get("Security"));
        // Technology
        assertEquals(0, civilization.getDiscoveries().get("Wheel"));
        assertEquals(0, civilization.getDiscoveries().get("Writing"));
        assertEquals(0, civilization.getDiscoveries().get("Steam Power"));
        assertEquals(0, civilization.getDiscoveries().get("Electricity"));
        assertEquals(0, civilization.getDiscoveries().get("Computers"));
        assertEquals(0, civilization.getDiscoveries().get("Artificial Intelligence"));

        // Culture
        assertEquals(0, civilization.getDiscoveries().get("Art"));
        assertEquals(0, civilization.getDiscoveries().get("Philosophy"));
        assertEquals(0, civilization.getDiscoveries().get("Music"));
        assertEquals(0, civilization.getDiscoveries().get("Theater"));
        assertEquals(0, civilization.getDiscoveries().get("Sculpting"));
        assertEquals(0, civilization.getDiscoveries().get("Renaissance"));

        // Faith
        assertEquals(0, civilization.getDiscoveries().get("Monotheism"));
        assertEquals(0, civilization.getDiscoveries().get("Polytheism"));
        assertEquals(0, civilization.getDiscoveries().get("Energies"));
        assertEquals(0, civilization.getDiscoveries().get("Divine Contact"));
        assertEquals(0, civilization.getDiscoveries().get("Enlightenment"));
        assertEquals(0, civilization.getDiscoveries().get("Universal Faith"));

        // Raw Materials
        assertEquals(0, civilization.getDiscoveries().get("Copper"));
        assertEquals(0, civilization.getDiscoveries().get("Iron"));
        assertEquals(0, civilization.getDiscoveries().get("Coal"));
        assertEquals(0, civilization.getDiscoveries().get("Oil"));
        assertEquals(0, civilization.getDiscoveries().get("Rare Earth Elements"));
        assertEquals(0, civilization.getDiscoveries().get("Nuclear Fusion"));

        // Security
        assertEquals(0, civilization.getDiscoveries().get("Basic Defense"));
        assertEquals(0, civilization.getDiscoveries().get("Archery"));
        assertEquals(0, civilization.getDiscoveries().get("Gunpowder"));
        assertEquals(0, civilization.getDiscoveries().get("Radar"));
        assertEquals(0, civilization.getDiscoveries().get("Invisibility"));
        assertEquals(0, civilization.getDiscoveries().get("Cybersecurity"));

        //Winning Discovery
        assertEquals(0, civilization.getDiscoveries().get("World Domination"));

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
        assertEquals(2, civilization.calculateVowelsAvgInWords("hola"));
    }

    @Test
    public void checkingVowelsAvgInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(2, civilization.calculateVowelsAvgInWords("hola", "adios"));
    }

    @Test
    public void checkingVowelsAvgInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(1, civilization.calculateVowelsAvgInWords("one", "two", "three", "four", "five"));
    }

    @Test
    public void checkingConsonantsAvgInOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(2, civilization.calculateConsonantsAvgInWords("hola"));
    }

    @Test
    public void checkingConsonantsAvgInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(4, civilization.calculateConsonantsAvgInWords("hola", "butterfly"));
    }

    @Test
    public void checkingConsonantsAvgInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(4, civilization.calculateConsonantsAvgInWords("hola", "butterfly", "argentum", "online", "twitch"));
    }

    @Test
    public void checkIfWordContainsVowelCluster() {
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordContainsVowelCluster("Aeris"), "Not containing vowel cluster");
    }

    @Test
    public void checkingVowelClusterRateForOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100, civilization.calculateVowelClusterRateInWords("Aeris"));
    }

    @Test
    public void checkingVowelClusterRateForTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50, civilization.calculateVowelClusterRateInWords("Aeris", "Aki"));
    }

    @Test
    public void checkingVowelClusterRateForFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(60, civilization.calculateVowelClusterRateInWords("Aeris", "Aki", "Paella", "Man", "Theodor"));
    }

    @Test
    public void checkXYZContainedInOneWord() {
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordContainsXYZ("Zaphire"), "Word does not contain Z");
    }

    @Test
    public void checkXYZRateInOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100, civilization.calculateXYZRateInWords("Yemen"));
    }

    @Test
    public void checkXYZRateInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50, civilization.calculateXYZRateInWords("Yemen", "Aki"));
    }

    @Test
    public void checkXYZRateInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(40, civilization.calculateXYZRateInWords("Xatu", "Maunuel", "Rodrigo", "Pablo", "Alexandria"));
    }

    @Test
    public void checkHContainedInOneWord() {
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordContainsH("Harry"), "Word does not contain H");
    }

    @Test
    public void checkHRateInOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100, civilization.calculateHRateInWords("Honey"));
    }

    @Test
    public void checkHRateInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50, civilization.calculateHRateInWords("Aki", "Home"));
    }

    @Test
    public void checkHRateInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(20, civilization.calculateHRateInWords("Ceverus", "Harry", "Snape", "Dumbledore", "Sorry"));
    }

    @Test
    public void checkKRateInOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100, civilization.calculateKRateInWords("Khalid"));
    }

    @Test
    public void checkKRateInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50, civilization.calculateKRateInWords("Khalid", "Sandra"));

    }

    @Test
    public void checkKRateInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(60, civilization.calculateKRateInWords("Khalid", "Sandra", "Kun", "Kamilla", "Arroz"));

    }

    @Test
    public void checkRRRateInOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100, civilization.calculateRRRateInWords("Arroz"));
    }

    @Test
    public void checkRRRateInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50, civilization.calculateRRRateInWords("Amarrar", "Pero"));
    }

    @Test
    public void checkRRRateInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(25, civilization.calculateRRRateInWords("Pez", "Perro", "Cama", "Arbol"));
    }

    @Test
    public void checkIfWordContainsConsonantCluster() {
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordContainsConsonantCluster("Pentar"), "Does not contain consonant cluster");

    }

    @Test
    public void checkConsonantClusterRateInOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100, civilization.calculateConsonantClusterRateInWords("Manco"));
    }

    @Test
    public void checkConsonantClusterRateInTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50, civilization.calculateConsonantClusterRateInWords("Manco", "Aki"));

    }

    @Test
    public void checkConsonantClusterRateInFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(60, civilization.calculateConsonantClusterRateInWords("Manco", "Aki", "Michaela", "Juan", "Ptak"));

    }

    @Test
    public void checkIfWordStatsWithVowel() {
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordStartsWithVowel("Aragorn"), "It does not start with a vowel");
    }

    @Test
    public void checkVowelStartRateForOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100, civilization.calculateVowelStartingRate("Aragorn"));
    }

    @Test
    public void checkVowelStartRateForTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50, civilization.calculateVowelStartingRate("Gimli", "Aragorn"));
    }

    @Test
    public void checkVowelStartRateForFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(50, civilization.calculateVowelStartingRate("Gimli", "Aragorn", "Legolas", "Aramir"));
    }

    @Test
    public void checkIfWordStatsWithConsonant() {
        Civilization civilization = new Civilization();
        assertFalse(civilization.checkIfWordStartsWithVowel("Legolas"), "It does not start with a consonant");
    }

    @Test
    public void checkConsonantStartRateForOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100, civilization.calculateConsonantStartingRate("Legolas"));
    }

    @Test
    public void checkConsonantStartRateForTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50, civilization.calculateConsonantStartingRate("Legolas", "Aragorn"));
    }

    @Test
    public void checkConsonantStartRateForFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(80, civilization.calculateConsonantStartingRate("Legolas", "Aragorn", "Froddo", "Sam", "Gandalf"));
    }

    @Test
    public void checkIfWordFinishesWithVowel() {
        Civilization civilization = new Civilization();
        assertTrue(civilization.checkIfWordFinishesWithVowel("Aki"), "It does not  finish with a vowel");
    }

    @Test
    public void checkIfWordFinishesWithConsonant() {
        Civilization civilization = new Civilization();
        assertFalse(civilization.checkIfWordFinishesWithVowel("Kulturak"), "It does not  finish with a vowel");
    }

    @Test
    public void checkWordFinishingWithVowelRateForOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100, civilization.calculateFinishingWithVowelRate("Aki"));
    }

    @Test
    public void checkWordFinishingWithVowelRateForTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50, civilization.calculateFinishingWithVowelRate("Aki", "Valt"));
    }

    @Test
    public void checkWordFinishingWithVowelRateForFiveWords() {
        Civilization civilization = new Civilization();
        assertEquals(60, civilization.calculateFinishingWithVowelRate("Aki", "Michaela", "Kandrik", "Chick", "Pablo"));
    }

    @Test
    public void checkWordFinishingWithConsonantRateForOneWord() {
        Civilization civilization = new Civilization();
        assertEquals(100, civilization.calculateFinishingWithConsonantRate("Akix"));
    }

    @Test
    public void checkWordFinishingWithConsonantRateForTwoWords() {
        Civilization civilization = new Civilization();
        assertEquals(50, civilization.calculateFinishingWithConsonantRate("Aki", "Valt"));
    }

    @Test
    public void checkWordFinishingWithConsonantRateForFiveWord() {
        Civilization civilization = new Civilization();
        assertEquals(60, civilization.calculateFinishingWithConsonantRate("Akix", "Michaela", "Kandrik", "Chick", "Pablo"));
    }
/*


    @Test
    public void checkLanguagePatternsInOneWord() {
        Civilization civilization = new Civilization();
        civilization.feedLanguagePattern("Aerithxkrr");
        String generatedWord = civilization.generateWord();

        System.out.println("Attempts: " + civilization.getAttempts());
        System.out.println("Generated word: " + generatedWord);
        System.out.println("Vowel Avg: " + civilization.calculateVowelsAvgInWords(generatedWord));
        System.out.println("Consonant Avg: " + civilization.calculateConsonantsAvgInWords(generatedWord));
        System.out.println("Vowel Cluster Rate: " + civilization.calculateVowelClusterRateInWords(generatedWord));
        System.out.println("Consonant Cluster Rate: " + civilization.calculateConsonantClusterRateInWords(generatedWord));
        System.out.println("XYZ Rate: " + civilization.calculateXYZRateInWords(generatedWord));
        System.out.println("H Rate: " + civilization.calculateHRateInWords(generatedWord));
        System.out.println("K Rate: " + civilization.calculateKRateInWords(generatedWord));
        System.out.println("RR Rate: " + civilization.calculateRRRateInWords(generatedWord));
        System.out.println("Vowel Starting Rate: " + civilization.calculateVowelStartingRate(generatedWord));
        System.out.println("Consonant Starting Rate: " + civilization.calculateConsonantStartingRate(generatedWord));

        assertEquals(3, civilization.calculateVowelsAvgInWords(generatedWord));
        assertEquals(7, civilization.calculateConsonantsAvgInWords(generatedWord));
        assertEquals(100, civilization.calculateVowelClusterRateInWords(generatedWord));
        assertEquals(100, civilization.calculateConsonantClusterRateInWords(generatedWord));
        assertEquals(100, civilization.calculateXYZRateInWords(generatedWord));
        assertEquals(100, civilization.calculateHRateInWords(generatedWord));
        assertEquals(100, civilization.calculateKRateInWords(generatedWord));
        assertEquals(100, civilization.calculateRRRateInWords(generatedWord));
        assertEquals(100, civilization.calculateVowelStartingRate(generatedWord));
        assertEquals(0, civilization.calculateConsonantStartingRate(generatedWord));
        assertEquals(0, civilization.calculateFinishingWithVowelRate(generatedWord));
        assertEquals(100, civilization.calculateFinishingWithConsonantRate(generatedWord));

    }


    @Test
    public void checkLanguagePatternsInFiveWords() {
        Civilization civilization = new Civilization();
        civilization.feedLanguagePattern("Oxhyrrekia", "Uzkhyrria", "Ixhyrruka", "Exhyrroka", "Azkhyrrea");

        String generatedWord = civilization.generateWord();

        System.out.println("Attempts: " + civilization.getAttempts());
        System.out.println("Generated word: " + generatedWord);
        System.out.println("Vowel Avg: " + civilization.calculateVowelsAvgInWords(generatedWord));
        System.out.println("Consonant Avg: " + civilization.calculateConsonantsAvgInWords(generatedWord));
        System.out.println("Vowel Cluster Rate: " + civilization.calculateVowelClusterRateInWords(generatedWord));
        System.out.println("Consonant Cluster Rate: " + civilization.calculateConsonantClusterRateInWords(generatedWord));
        System.out.println("XYZ Rate: " + civilization.calculateXYZRateInWords(generatedWord));
        System.out.println("H Rate: " + civilization.calculateHRateInWords(generatedWord));
        System.out.println("K Rate: " + civilization.calculateKRateInWords(generatedWord));
        System.out.println("RR Rate: " + civilization.calculateRRRateInWords(generatedWord));
        System.out.println("Vowel Starting Rate: " + civilization.calculateVowelStartingRate(generatedWord));
        System.out.println("Consonant Starting Rate: " + civilization.calculateConsonantStartingRate(generatedWord));


        assertEquals(3, civilization.calculateVowelsAvgInWords(generatedWord));
        assertEquals(6, civilization.calculateConsonantsAvgInWords(generatedWord));
        assertEquals(60, civilization.calculateVowelClusterRateInWords(generatedWord));
        assertEquals(100, civilization.calculateConsonantClusterRateInWords(generatedWord));
        assertEquals(100, civilization.calculateXYZRateInWords(generatedWord));
        assertEquals(100, civilization.calculateHRateInWords(generatedWord));
        assertEquals(100, civilization.calculateKRateInWords(generatedWord));
        assertEquals(100, civilization.calculateRRRateInWords(generatedWord));
        assertEquals(100, civilization.calculateVowelStartingRate(generatedWord));
        assertEquals(0, civilization.calculateConsonantStartingRate(generatedWord));
        assertEquals(100, civilization.calculateFinishingWithVowelRate(generatedWord));
        assertEquals(0, civilization.calculateFinishingWithConsonantRate(generatedWord));

    }

    */

    @Test
    public void improvingTechnologyOnce() {
        Civilization civilization = new Civilization();
        civilization.improveResource("Technology");
        assertEquals(1, civilization.getResources().get("Technology"));
    }

    @Test
    public void improvingTechnologyFiveTimes() {
        Civilization civilization = new Civilization();
        civilization.improveResource("Technology");
        civilization.improveResource("Technology");
        civilization.improveResource("Technology");
        civilization.improveResource("Technology");
        civilization.improveResource("Technology");

        assertEquals(5, civilization.getResources().get("Technology"));
    }

    @Test
    public void discoveringOneThing() {
        Civilization civilization = new Civilization();
        civilization.improveResource("Technology");
        System.out.println(civilization.getResources().get("Technology"));
        civilization.discoverSomething();
        assertFalse(civilization.getDiscoveries().isEmpty());
    }
}