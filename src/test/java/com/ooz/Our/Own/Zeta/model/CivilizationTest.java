package com.ooz.Our.Own.Zeta.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CivilizationTest {

    @Test
    public void civilizationStartsAtZero() {

        Civilization civilization = new Civilization();
        assertEquals("", civilization.getName());
        assertEquals(0, civilization.getAge());
        assertTrue(civilization.getPopulation() >= 1 && civilization.getPopulation() <= 100);
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
        Person scientist = civilization.createImportantPerson(20, "Aki", "Scientist", new HashMap<>(), true, 0, new ArrayList<>());
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
        Person artist = civilization.createImportantPerson(20, "Aki", "Artist", new HashMap<>(), true, 0, new ArrayList<>());
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
        Person athlete = civilization.createImportantPerson(20, "Aki", "Athlete", new HashMap<>(), true, 0, new ArrayList<>());
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
        Person doctor = civilization.createImportantPerson(20, "Aki", "Doctor", new HashMap<>(), true, 0, new ArrayList<>());
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
        civilization.discoverSomething(100);
        String discovery = civilization.discoverSomething(100);
        assertTrue(discovery.contains("has discovered") || discovery.contains("The Civilization has not discovered anything"));

    }

    @Test
    public void discoveringSomethingOnce() {
        Civilization civilization = new Civilization();
        civilization.learningResource(100);
        String discovery = civilization.discoverSomething(100);
        assertTrue(discovery.contains("has discovered") || discovery.contains("The Civilization has not discovered anything"));
    }

    @Test
    public void learnResourceOnce() {
        Civilization civilization = new Civilization();
        civilization.learningResource(100);
        assertNotEquals("", civilization.learningResource(100));
    }

    @Test
    public void creatingRandomPersonWithoutName() {
        Civilization civilization = new Civilization();
        assertEquals("Error: There are no name patterns",
                civilization.createRandomPerson());
    }

    @Test
    public void creatingARandomPerson() {
        Civilization civilization = new Civilization();
        civilization.feedLanguagePattern("Manuel", "Pablo", "Ezequiel", "Rodrigo");
        assertTrue(civilization.getImportantIndividuals().isEmpty());
        civilization.createRandomPerson();
        assertFalse(civilization.getImportantIndividuals().isEmpty());
    }

    @Test
    public void logPersonCreationToEventsLog() {
        Civilization civilization = new Civilization();
        assertTrue(civilization.getEventsLog().isEmpty());
        civilization.feedLanguagePattern("Manuel", "Pablo", "Ezequiel", "Rodrigo");
        civilization.createRandomPerson();
        civilization.passTime(1);
        assertFalse(civilization.getImportantIndividuals().isEmpty());
        assertFalse(civilization.getEventsLog().isEmpty());
    }

    @Test
    public void logLearningResourceToEventsLog() {
        Civilization civilization = new Civilization();
        civilization.feedLanguagePattern("Manuel", "Pablo", "Ezequiel", "Rodrigo");
        civilization.setName(civilization.generateName());
        String learnedResource = civilization.learningResource(100);
        assertNotEquals("", learnedResource);
        assertFalse(civilization.getEventsLog().isEmpty());
    }

    @Test
    public void logNewDiscoveryToEventsLog() {
        Civilization civilization = new Civilization();
        civilization.feedLanguagePattern("Manuel", "Pablo", "Ezequiel", "Rodrigo");
        civilization.setName(civilization.generateName());
        String learnedResource = civilization.learningResource(100);
        assertNotEquals("", learnedResource);
        civilization.discoverSomething(100);
        // It varies assertFalse(civilization.getEventsLog().get(1).isEmpty());
    }

    @Test
    public void generatingNameForCivlization() {
        Civilization civilization = new Civilization();
        civilization.feedLanguagePattern("Manuel", "Pablo", "Ezequiel", "Rodrigo");
        civilization.setName(civilization.generateName());
        assertNotEquals("", civilization.getName());
    }


    @Test
    public void passing50Years() {
        Civilization civilization = new Civilization();
        civilization.feedLanguagePattern("Manuel", "Pablo", "Ezequiel", "Rodrigo");
        civilization.setName(civilization.generateName());
        civilization.createRandomPerson();
        civilization.passTime(50);
        System.out.println(civilization);
    }

    @Test
    public void calculate3ImportantPeopleValue() {
        Civilization civilization = new Civilization();
        civilization.feedLanguagePattern("Manuel", "Pablo", "Ezequiel", "Rodrigo");
        civilization.createRandomPerson();
        civilization.createRandomPerson();
        civilization.createRandomPerson();
        for (Map.Entry<String, Person> person : civilization.getImportantIndividuals().entrySet()) {
            person.getValue().discoverSomething(100);
            person.getValue().discoverSomething(100);
            person.getValue().discoverSomething(100);
        }
        assertEquals(1080, civilization.calculateImportantPeopleValue());
    }

    @Test
    public void calculateCivilizationValue() {
        Civilization civilization = new Civilization();
        civilization.feedLanguagePattern("Manuel", "Pablo", "Ezequiel", "Rodrigo");
        civilization.createRandomPerson();
        civilization.createRandomPerson();
        civilization.createRandomPerson();
        for (Map.Entry<String, Person> person : civilization.getImportantIndividuals().entrySet()) {
            person.getValue().discoverSomething(100);
            person.getValue().discoverSomething(100);
            person.getValue().discoverSomething(100);
        }
        assertEquals(1080 + (civilization.calculatePopulationValue()), civilization.calculateCivilizationValue());
        //Value So far 1080
        civilization.improveResource("Technology");
        civilization.improveResource("Culture");
        civilization.improveResource("Faith");
        assertEquals(1380 + (civilization.calculatePopulationValue()), civilization.calculateCivilizationValue());
        //Value So Far 1080 + 300
        Map<String, Integer> discoveries = new HashMap<>();
        discoveries.put("Monotheism", 1);
        discoveries.put("Oil", 1);
        discoveries.put("Gunpowder", 2);
        discoveries.put("World Domination", 1);
        civilization.setDiscoveries(discoveries);
        assertEquals(101980 + (civilization.calculatePopulationValue()), civilization.calculateCivilizationValue());

    }

    @Test
    public void pass50YearsForBothCivAndPeople() {
        Civilization civilization = new Civilization();
        civilization.feedLanguagePattern("Manuel", "Pablo", "Ezequiel", "Rodrigo");
        civilization.createRandomPerson();
        civilization.passTime(50);
        int civAge = civilization.getAge();
        int personAge = 0;
        for (Map.Entry<String, Person> person : civilization.getImportantIndividuals().entrySet()) {
            personAge += person.getValue().getAge();
        }
        assertEquals(civAge, personAge);
    }

    @Test
    public void passing150YearsAndSeeingHowItAffectsAPerson() {
        Civilization civilization = new Civilization();
        civilization.feedLanguagePattern("Manuel", "Pablo", "Ezequiel", "Rodrigo");
        civilization.createRandomPerson();
        List<String> personLifeLog = new ArrayList<>();
        for (Map.Entry<String, Person> person : civilization.getImportantIndividuals().entrySet()) {
            personLifeLog = person.getValue().getLifeLog();
        }
        civilization.passTime(150);
        assertTrue(civilization.getEventsLog().size() >= personLifeLog.size());
    }

    @Test
    public void passing150YearsAndSeeingHowItAffectsThreePeople() {
        Civilization civilization = new Civilization();
        civilization.feedLanguagePattern("Manuel", "Pablo", "Ezequiel", "Rodrigo");
        civilization.createRandomPerson();
        civilization.createRandomPerson();
        civilization.createRandomPerson();
        List<String> personLifeLog1 = new ArrayList<>();
        List<String> personLifeLog2 = new ArrayList<>();
        List<String> personLifeLog3 = new ArrayList<>();

        for (Map.Entry<String, Person> person : civilization.getImportantIndividuals().entrySet()) {
            if (personLifeLog1.isEmpty()) {
                personLifeLog1 = person.getValue().getLifeLog();
            } else if (personLifeLog2.isEmpty()) {
                personLifeLog2 = person.getValue().getLifeLog();
            } else if (personLifeLog3.isEmpty()) {
                personLifeLog3 = person.getValue().getLifeLog();
            }
        }
        civilization.passTime(150);
        assertTrue(civilization.getEventsLog().size() >= (personLifeLog1.size() + personLifeLog2.size() + personLifeLog3.size()));
    }

    @Test
    public void sufferNaturalDisaster() {
        Civilization civilization = new Civilization();
        civilization.feedLanguagePattern("Manuel", "Pablo", "Ezequiel", "Rodrigo");
        civilization.generateName();
        civilization.setPopulation(1000);
        civilization.createRandomPerson();
        civilization.createNaturalDisaster(100);
        civilization.passTime(1);
        assertFalse(civilization.getEventsLog().isEmpty());
        assertTrue(civilization.getEventsLog().size() >= 2);
    }

    @Test
    public void testNamePresets() {
        Civilization civ = new Civilization();
        String[] orcPreset = civ.useNamePreset("Orc");
        String[] dwarfPreset = civ.useNamePreset("Dwarf");
        String[] elfPreset = civ.useNamePreset("Elf");
        String[] humanPreset = civ.useNamePreset("Human");
        String[] orientalWarriorPreset = civ.useNamePreset("Oriental Warrior");
        String[] murlockPreset = civ.useNamePreset("Murlock");
        String[] ogrePreset = civ.useNamePreset("Ogre");
        //
        civ.feedLanguagePattern(orcPreset);
        civ.setName(civ.generateName());
        assertFalse(civ.getName().isEmpty());
        //
        civ.setLanguagePatterns(new HashMap<>());
        civ.setName("");
        //
        civ.feedLanguagePattern(dwarfPreset);
        civ.setName(civ.generateName());
        assertFalse(civ.getName().isEmpty());
        //
        civ.setLanguagePatterns(new HashMap<>());
        civ.setName("");
        //
        civ.feedLanguagePattern(elfPreset);
        civ.setName(civ.generateName());
        assertFalse(civ.getName().isEmpty());
        //
        civ.setLanguagePatterns(new HashMap<>());
        civ.setName("");
        //
        civ.feedLanguagePattern(humanPreset);
        civ.setName(civ.generateName());
        assertFalse(civ.getName().isEmpty());
        //
        civ.setLanguagePatterns(new HashMap<>());
        civ.setName("");
        //
        civ.feedLanguagePattern(orientalWarriorPreset);
        civ.setName(civ.generateName());
        assertFalse(civ.getName().isEmpty());
        //
        civ.setLanguagePatterns(new HashMap<>());
        civ.setName("");
        //
        civ.feedLanguagePattern(murlockPreset);
        civ.setName(civ.generateName());
        assertFalse(civ.getName().isEmpty());
        //
        civ.setLanguagePatterns(new HashMap<>());
        civ.setName("");
        //
        civ.feedLanguagePattern(ogrePreset);
        civ.setName(civ.generateName());
        assertFalse(civ.getName().isEmpty());
        //
    }
}