package com.ooz.Our.Own.Zeta.model;

import java.util.*;

public class Civilization {

    int attempts = 0;
    private String name;
    private int age;
    private Map<String, Integer> resources = new HashMap<>(); // <Resources Name, Level>
    private Map<String, Integer> discoveries = new HashMap<>(); // <Discoveries Name, Level>
    private int population;
    private Map<String, Person> importantIndividuals = new HashMap<>();
    private List<String> eventsLog = new ArrayList<>();
    private Map<String, Integer> languagePatterns = new HashMap<>();

    /// ////////// END FIELDS

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getLanguagePatterns() {
        return languagePatterns;
    }

    public void setLanguagePatterns(Map<String, Integer> languagePatterns) {
        this.languagePatterns = languagePatterns;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Integer> getResources() {
        Map<String, Integer> resourcesNotZero = new HashMap<>();
        for (Map.Entry<String, Integer> resource : resources.entrySet()) {
            if (resource.getValue() > 0) {
                resourcesNotZero.put(resource.getKey(), resource.getValue());
            }
        }
        return resourcesNotZero;
    }

    public void setResources(Map<String, Integer> resources) {
        this.resources = resources;
    }

    public Map<String, Integer> getDiscoveries() {
        Map<String, Integer> discoveriesNotZero = new HashMap<>();
        for (Map.Entry<String, Integer> discovery : discoveries.entrySet()) {
            if (discovery.getValue() > 0) {
                discoveriesNotZero.put(discovery.getKey(), discovery.getValue());
            }
        }
        return discoveriesNotZero;
    }

    public void setDiscoveries(Map<String, Integer> discoveries) {
        this.discoveries = discoveries;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Map<String, Person> getImportantIndividuals() {
        return importantIndividuals;
    }

    public void setImportantIndividuals(Map<String, Person> importantIndividuals) {
        this.importantIndividuals = importantIndividuals;
    }

    public List<String> getEventsLog() {
        return eventsLog;
    }

    public void setEventsLog(List<String> eventsLog) {
        this.eventsLog = eventsLog;
    }

    public Civilization() {
        this.name = "";
        this.age = 0;
        this.discoveries = new HashMap<>();
        this.eventsLog = new ArrayList<>();
        this.resources = new HashMap<>();
        this.population = 0;
        this.importantIndividuals = new HashMap<>();
        this.languagePatterns = new HashMap<>();
        resources.put("Technology", 0);
        resources.put("Culture", 0);
        resources.put("Faith", 0);
        resources.put("Raw Materials", 0);
        resources.put("Security", 0);
        languagePatterns.put("VowelsPerWord", 0);
        languagePatterns.put("ConsonantsPerWord", 0);
        languagePatterns.put("VowelClusterRate", 0);
        languagePatterns.put("ConsonantClusterRate", 0);
        languagePatterns.put("XYZRate", 0);
        languagePatterns.put("HRate", 0);
        languagePatterns.put("KRate", 0);
        languagePatterns.put("RRRate", 0);
        languagePatterns.put("StartsWithVowelRate", 0);
        languagePatterns.put("StartsWithConsonantRate", 0);
        languagePatterns.put("FinishesWithVowelRate", 0);
        languagePatterns.put("FinishesWithConsonantRate", 0);
        //Technolgy
        discoveries.put("Wheel", 0);
        discoveries.put("Writing", 0);
        discoveries.put("Steam Power", 0);
        discoveries.put("Electricity", 0);
        discoveries.put("Computers", 0);
        discoveries.put("Artificial Intelligence", 0);
        //Culture
        discoveries.put("Art", 0);
        discoveries.put("Philosophy", 0);
        discoveries.put("Music", 0);
        discoveries.put("Theater", 0);
        discoveries.put("Sculpting", 0);
        discoveries.put("Renaissance", 0);
        //Faith
        discoveries.put("Monotheism", 0);
        discoveries.put("Polytheism", 0);
        discoveries.put("Energies", 0);
        discoveries.put("Divine Contact", 0);
        discoveries.put("Enlightenment", 0);
        discoveries.put("Universal Faith", 0);
        //Raw Materials
        discoveries.put("Copper", 0);
        discoveries.put("Iron", 0);
        discoveries.put("Coal", 0);
        discoveries.put("Oil", 0);
        discoveries.put("Rare Earth Elements", 0);
        discoveries.put("Nuclear Fusion", 0);
        //Security
        discoveries.put("Basic Defense", 0);
        discoveries.put("Archery", 0);
        discoveries.put("Gunpowder", 0);
        discoveries.put("Radar", 0);
        discoveries.put("Invisibility", 0);
        discoveries.put("Cybersecurity", 0);
        //Winning Discovery
        discoveries.put("World Domination", 0);
    }

    public void feedLanguagePattern(String... words) {
        languagePatterns.put("VowelsPerWord", calculateVowelsAvgInWords(words[0], Arrays.copyOfRange(words, 1, words.length)));
        languagePatterns.put("ConsonantsPerWord", calculateConsonantsAvgInWords(words[0], Arrays.copyOfRange(words, 1, words.length)));
        languagePatterns.put("VowelClusterRate", calculateVowelClusterRateInWords(words[0], Arrays.copyOfRange(words, 1, words.length)));
        languagePatterns.put("ConsonantClusterRate", calculateConsonantClusterRateInWords(words[0], Arrays.copyOfRange(words, 1, words.length)));
        languagePatterns.put("XYZRate", calculateXYZRateInWords(words[0], Arrays.copyOfRange(words, 1, words.length)));
        languagePatterns.put("HRate", calculateHRateInWords(words[0], Arrays.copyOfRange(words, 1, words.length)));
        languagePatterns.put("KRate", calculateKRateInWords(words[0], Arrays.copyOfRange(words, 1, words.length)));
        languagePatterns.put("RRRate", calculateRRRateInWords(words[0], Arrays.copyOfRange(words, 1, words.length)));
        languagePatterns.put("StartsWithVowelRate", calculateVowelStartingRate(words[0], Arrays.copyOfRange(words, 1, words.length)));
        languagePatterns.put("StartsWithConsonantRate", calculateConsonantStartingRate(words[0], Arrays.copyOfRange(words, 1, words.length)));
        languagePatterns.put("FinishesWithVowelRate", calculateFinishingWithVowelRate(words[0], Arrays.copyOfRange(words, 1, words.length)));
        languagePatterns.put("FinishesWithConsonantRate", calculateFinishingWithConsonantRate(words[0], Arrays.copyOfRange(words, 1, words.length)));
    }

    public String generateWord() {
        Random random = new Random();
        boolean generateVowelCluster = false;
        boolean generateConsonantCluster = false;
        boolean generateXYZ = false;
        boolean generateH = false;
        boolean generateK = false;
        boolean generateRR = false;
        boolean generateVowelStarting = false;
        boolean generateConsonantStarting = false;
        boolean generateVowelFinishing = false;
        boolean generateConsonantFinishing = false;
        int vowelAvgAmount = (int) Math.round(languagePatterns.get("VowelsPerWord"));
        int consonantAvgAmount = (int) Math.round(languagePatterns.get("ConsonantsPerWord"));

        // Determinación de las probabilidades de generación
        if (random.nextInt(1, 101) <= languagePatterns.get("VowelClusterRate").intValue()) {
            generateVowelCluster = true;
        }
        if (random.nextInt(1, 101) <= languagePatterns.get("ConsonantClusterRate").intValue()) {
            generateConsonantCluster = true;
        }
        if (random.nextInt(1, 101) <= languagePatterns.get("XYZRate")) {
            generateXYZ = true;
        }
        if (random.nextInt(1, 101) <= languagePatterns.get("HRate")) {
            generateH = true;
        }
        if (random.nextInt(1, 101) <= languagePatterns.get("KRate")) {
            generateK = true;
        }
        if (random.nextInt(1, 101) <= languagePatterns.get("RRRate")) {
            generateRR = true;
        }
        // Lógica de generación de inicio y final de la palabra (vocales o consonantes)
        if (languagePatterns.get("StartsWithVowelRate") >= languagePatterns.get("StartsWithConsonantRate")) {
            if (random.nextInt(1, 101) <= languagePatterns.get("StartsWithVowelRate")) {
                generateVowelStarting = true;
            } else {
                generateConsonantStarting = true;
            }
        } else {
            if (random.nextInt(1, 101) <= languagePatterns.get("StartsWithConsonantRate")) {
                generateConsonantStarting = true;
            } else {
                generateVowelStarting = true;
            }
        }
        if (languagePatterns.get("FinishesWithVowelRate") >= languagePatterns.get("FinishesWithConsonantRate")) {
            if (random.nextInt(1, 101) <= languagePatterns.get("FinishesWithVowelRate")) {
                generateVowelFinishing = true;
            } else {
                generateConsonantFinishing = true;
            }
        } else {
            if (random.nextInt(1, 101) <= languagePatterns.get("FinishesWithConsonantRate")) {
                generateConsonantFinishing = true;
            } else {
                generateVowelFinishing = true;
            }
        }

        StringBuilder generatedWord = new StringBuilder();
        String wordToString;
        int vowelsToPlace;
        int consonantsToPlace;
        int totalCharacters = vowelAvgAmount + consonantAvgAmount;
        final int maxAttempts = 100000;

        do {


            do {
                generatedWord.setLength(0);  // Limpiar la palabra generada
                vowelsToPlace = vowelAvgAmount;
                consonantsToPlace = consonantAvgAmount;
                String vowels = "aeiou";
                String consonants = "bcdfghjklmnpqrstvwxyz";
                String xyzLetters = "xyz";
                for (int i = 0; i < totalCharacters; i++) {
                    if (i == 0) {
                        if (generateVowelStarting) {
                            generatedWord.append(Character.toUpperCase(vowels.charAt(random.nextInt(vowels.length()))));
                            vowelsToPlace--;
                        } else {
                            generatedWord.append(Character.toUpperCase(consonants.charAt(random.nextInt(consonants.length()))));
                            consonantsToPlace--;
                        }
                    } else if (i == (totalCharacters - 1)) {
                        if (generateVowelFinishing) {
                            generatedWord.append(vowels.charAt(random.nextInt(vowels.length())));
                            vowelsToPlace--;
                        } else {
                            generatedWord.append(consonants.charAt(random.nextInt(consonants.length())));
                            consonantsToPlace--;
                        }
                    } else {
                        // Aquí puedes ajustar la lógica de selección de vocales y consonantes
                        if (vowelsToPlace > 0 && consonantsToPlace > 0) {
                            if (random.nextBoolean()) {
                                generatedWord.append(vowels.charAt(random.nextInt(vowels.length())));
                                vowelsToPlace--;
                            } else {
                                generatedWord.append(consonants.charAt(random.nextInt(consonants.length())));
                                consonantsToPlace--;
                            }
                        } else if (vowelsToPlace > 0) {
                            generatedWord.append(vowels.charAt(random.nextInt(vowels.length())));
                            vowelsToPlace--;
                        } else {
                            generatedWord.append(consonants.charAt(random.nextInt(consonants.length())));
                            consonantsToPlace--;
                        }
                    }
                }
            }
            while (calculateVowelsAvgInWords(generatedWord.toString()) != vowelAvgAmount &&
                    calculateConsonantsAvgInWords(generatedWord.toString()) != consonantAvgAmount);


            wordToString = generatedWord.toString();
            attempts++;  // Incrementa el número de intentos

            // Verifica si los intentos deben continuar
            if (attempts >= maxAttempts) {
                break;  // Detén el bucle después de maxAttempts
            }
        } while (
                wordToString.length() != totalCharacters ||
                        generateXYZ != checkIfWordContainsXYZ(wordToString) ||
                        generateH != checkIfWordContainsH(wordToString) ||
                        generateK != checkIfWordContainsK(wordToString) ||
                        generateRR != checkIfWordContainsRR(wordToString) ||
                        generateVowelStarting != checkIfWordStartsWithVowel(wordToString) ||
                        generateVowelFinishing != checkIfWordFinishesWithVowel(wordToString));

        return wordToString;
    }


    public void passTime(int years) {
        age += years;
        for (Map.Entry<String, Person> person : importantIndividuals.entrySet()) {
            person.getValue().pasOneYear();
            for (String event : person.getValue().getLifeLog()) {
                getEventsLog().add(event);
            }
        }
    }

    public int calculateCivilizationValue() {
        return (calculatePopulatiionValue() +
                calculateImportantPeopleValue()) +
                calculateDiscoveriesValue() +
                calculateResourcesValue();
    }

    public int calculateDiscoveriesValue() {
        // Each Discovery is worth 150 points
        int discoveriesValue = 0;

        for (Map.Entry<String, Integer> discovery : getDiscoveries().entrySet()) {
            if (discovery.getKey().equals("World Domination") && discovery.getValue() == 1) {
                discoveriesValue += discovery.getValue() * 100000;
            } else {
                discoveriesValue += discovery.getValue() * 150;
            }
        }
        return discoveriesValue;
    }

    public int calculateResourcesValue() {
        // Each resource is worth 100 points
        int resourcesValue = 0;

        for (Map.Entry<String, Integer> resource : getResources().entrySet()) {
            resourcesValue += resource.getValue() * 100;
        }
        return resourcesValue;
    }

    public int calculatePopulatiionValue() {
        return population * 5;
    }

    public int calculateImportantPeopleValue() {
        int importantPeopleValue = 0;

        for (Map.Entry<String, Person> person : importantIndividuals.entrySet()) {
            importantPeopleValue += person.getValue().calculateValue();
        }
        return importantPeopleValue;
    }

    public Person createImportantPerson(int age, String name, String field, Map<String, Integer> discoveries, boolean alive, int knowledge, List<String> lifeLog) {
        Person person = null;
        switch (field) {
            case "Scientist":
                person = new Scientist(age, name, field, discoveries, alive, knowledge, lifeLog);
                break;
            case "Artist":
                person = new Artist(age, name, field, discoveries, alive, knowledge, lifeLog);
                break;
            case "Athlete":
                person = new Athlete(age, name, field, discoveries, alive, knowledge, lifeLog);
                break;
            case "Doctor":
                person = new Doctor(age, name, field, discoveries, alive, knowledge, lifeLog);
                break;
        }
        return person;
    }

    public String createRandomPerson() {
        String message = "";
        if (languagePatterns.get("VowelsPerWord") == 0 && languagePatterns.get("ConsonantsPerWord") == 0) {
            message = "Error: There are no name patterns";
        } else {
            Random random = new Random();
            int typeOfPerson = random.nextInt(1, 5);//1 Artist 2 Athlete 3 Doctor 4 Scientist
            String fieldToBe = "";
            switch (typeOfPerson) {
                case 1:
                    fieldToBe = "Artist";
                    break;
                case 2:
                    fieldToBe = "Athlete";
                    break;
                case 3:
                    fieldToBe = "Doctor";
                    break;
                case 4:
                    fieldToBe = "Scientist";
                    break;
                default:
                    fieldToBe = "Cannot generate field";
            }
            if (!fieldToBe.equals("Cannot generate field")) {
                Person createdPerson = createImportantPerson(0, generateWord(), fieldToBe, new HashMap<String, Integer>(), true, 0, new ArrayList<String>());
                importantIndividuals.put(createdPerson.getName(), createdPerson);
                message = createdPerson.getName() + ", a promising " + createdPerson.getField().toLowerCase() + " was born!";
                logEventPerson(createdPerson);
            }
        }
        return message;
    }

    public void logEventPerson(Person personToLog) {
        //Types of events
        /*
        "Birth" = new important person was born
        "Resource" = civilization learned a new resource
         */
        if (personToLog != null) {
            eventsLog.add("Year " + age + ": " + personToLog.getName() + ", a promising " + personToLog.getField().toLowerCase() + " was born");
        }
    }

    public void logEventResource(String resourceToLog) {
        //Types of events
        /*
        "Birth" = new important person was born
        "Resource" = civilization learned a new resource
         */
        if (!resourceToLog.isEmpty() && !name.isBlank()) {
            eventsLog.add("Year " + age + ": The " + name + " people has improved their " + resourceToLog.toLowerCase() + ", " + resourceToLog + " is now Level " + resources.get(resourceToLog));
        }
    }

    public String generateName() {
        Random random = new Random();
        int randomNumber = random.nextInt(1, 3);
        String finishing = "";
        if (randomNumber == 1) {
            finishing = "s";
        } else if (randomNumber == 2) {
            finishing = "an";
        }
        return generateWord() + finishing;
    }

    public int calculateVowelsAvgInWords(String word, String... others) {
        char[] wordInChar = word.toLowerCase().toCharArray();
        int amountOfVowels = 0;
        int totalWords = 1 + others.length;

        amountOfVowels += countVowels(word);

        for (String other : others) {
            amountOfVowels += countVowels(other);
        }

        return amountOfVowels / totalWords;
    }

    private int countVowels(String word) {
        int count = 0;
        for (char character : word.toLowerCase().toCharArray()) {
            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                count++;
            }
        }
        return count;
    }

    public int calculateConsonantsAvgInWords(String word, String... others) {
        char[] wordInChar = word.toLowerCase().toCharArray();
        int amountOfConsonants = 0;
        int totalWords = 1 + others.length;

        amountOfConsonants += countConsonants(word);

        for (String other : others) {
            amountOfConsonants += countConsonants(other);
        }

        return amountOfConsonants / totalWords;
    }

    private int countConsonants(String word) {
        int count = 0;
        for (char character : word.toLowerCase().toCharArray()) {
            if (character != 'a' && character != 'e' && character != 'i' && character != 'o' && character != 'u') {
                count++;
            }
        }
        return count;
    }

    public boolean checkIfWordContainsVowelCluster(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (i < (word.length() - 1)) {
                if ((word.toLowerCase().toCharArray()[i] == 'a' || word.toLowerCase().toCharArray()[i] == 'e' || word.toLowerCase().toCharArray()[i] == 'i' || word.toLowerCase().toCharArray()[i] == 'o' || word.toLowerCase().toCharArray()[i] == 'u') && (word.toLowerCase().toCharArray()[i + 1] == 'a' || word.toLowerCase().toCharArray()[i + 1] == 'e' || word.toLowerCase().toCharArray()[i + 1] == 'i' || word.toLowerCase().toCharArray()[i + 1] == 'o' || word.toLowerCase().toCharArray()[i + 1] == 'u')) {
                    return true;
                }
            }
        }
        return false;
    }

    public int calculateVowelClusterRateInWords(String word, String... others) {
        int words = 1 + others.length;
        int wordsWCluster = 0;
        int wordsWithVowelClusterRate = 0;
        if (checkIfWordContainsVowelCluster(word)) {
            wordsWCluster++;
        }

        for (int i = 0; i < others.length; i++) {
            if (checkIfWordContainsVowelCluster(others[i])) {
                wordsWCluster++;
            }
        }

        wordsWithVowelClusterRate = (wordsWCluster * 100 / words);

        return wordsWithVowelClusterRate;

    }

    public boolean checkIfWordContainsXYZ(String word) {
        char[] wordToChar = word.toLowerCase().toCharArray();

        for (char character : wordToChar) {
            if (character == 'x' || character == 'y' || character == 'z') {
                return true;
            }
        }
        return false;
    }

    public int calculateXYZRateInWords(String word, String... others) {
        int amountOfWords = 1 + others.length;
        int amountOfXYZWords = 0;
        if (checkIfWordContainsXYZ(word)) {
            amountOfXYZWords++;
        }

        for (String wordOther : others) {
            if (checkIfWordContainsXYZ(wordOther)) {
                amountOfXYZWords++;
            }
        }

        return amountOfXYZWords * 100 / amountOfWords;
    }

    public boolean checkIfWordContainsH(String word) {
        char[] wordChar = word.toLowerCase().toCharArray();
        for (char character : wordChar) {
            if (character == 'h') {
                return true;
            }
        }
        return false;

    }

    public int calculateHRateInWords(String word, String... others) {
        int amountOfWords = 1 + others.length;
        int wordsWithH = 0;

        if (checkIfWordContainsH(word)) {
            wordsWithH++;
        }

        for (String wordToCheck : others) {
            if (checkIfWordContainsH(wordToCheck)) {
                wordsWithH++;
            }
        }

        return wordsWithH * 100 / amountOfWords;

    }

    public boolean checkIfWordContainsK(String word) {
        char[] wordChar = word.toLowerCase().toCharArray();
        for (int i = 0; i < wordChar.length; i++) {
            if (wordChar[i] == 'k') {
                return true;
            }

        }
        return false;
    }

    public int calculateKRateInWords(String word, String... others) {
        int words = 1 + others.length;
        int wordsWithK = 0;
        if (checkIfWordContainsK(word)) {
            wordsWithK++;
        }
        for (String wordToCheck : others) {
            if (checkIfWordContainsK(wordToCheck)) {
                wordsWithK++;
            }
        }
        return (wordsWithK * 100) / words;
    }

    public Boolean checkIfWordContainsRR(String word) {
        char[] wordChar = word.toLowerCase().toCharArray();
        for (int i = 0; i < wordChar.length; i++) {

            if (i < (wordChar.length - 1)) {
                if (wordChar[i] == 'r' && wordChar[(i + 1)] == 'r') {
                    return true;
                }
            }

        }
        return false;
    }

    public int calculateRRRateInWords(String word, String... others) {
        int totalWords = 1 + others.length;
        int wordsWithRR = 0;
        if (checkIfWordContainsRR(word)) {
            wordsWithRR++;
        }
        for (String wordToCheck : others) {
            if (checkIfWordContainsRR(wordToCheck)) {
                wordsWithRR++;
            }
        }
        return wordsWithRR * 100 / totalWords;
    }

    public Boolean checkIfWordContainsConsonantCluster(String word) {
        char[] wordCharArr = word.toLowerCase().toCharArray();
        for (int i = 0; i < wordCharArr.length; i++) {
            if (i < (wordCharArr.length - 1)) {
                if (wordCharArr[i] != 'a' && wordCharArr[i] != 'e' && wordCharArr[i] != 'i' && wordCharArr[i] != 'o' && wordCharArr[i] != 'u' && wordCharArr[i + 1] != 'a' && wordCharArr[i + 1] != 'e' && wordCharArr[i + 1] != 'i' && wordCharArr[i + 1] != 'o' && wordCharArr[i + 1] != 'u') {
                    return true;
                }
            }
        }
        return false;
    }

    public int calculateConsonantClusterRateInWords(String word, String... others) {
        int totalWords = 1 + others.length;
        int totalConsonantClusterWords = 0;

        if (checkIfWordContainsConsonantCluster(word)) {
            totalConsonantClusterWords++;
        }
        for (String wordToCheck : others) {
            if (checkIfWordContainsConsonantCluster(wordToCheck)) {
                totalConsonantClusterWords++;
            }
        }

        return totalConsonantClusterWords * 100 / totalWords;

    }

    public Boolean checkIfWordStartsWithVowel(String word) {
        char[] wordArray = word.toLowerCase().toCharArray();
        if (wordArray[0] == 'a' || wordArray[0] == 'e' || wordArray[0] == 'i' || wordArray[0] == 'o' || wordArray[0] == 'u') {
            return true;
        }
        return false;
    }

    public int calculateVowelStartingRate(String word, String... others) {
        int totalWords = 1 + others.length;
        int totalWordsStartingWVowel = 0;
        if (checkIfWordStartsWithVowel(word)) {
            totalWordsStartingWVowel++;
        }

        for (String wordToCheck : others) {
            if (checkIfWordStartsWithVowel(wordToCheck)) {
                totalWordsStartingWVowel++;
            }
        }
        return totalWordsStartingWVowel * 100 / totalWords;
    }

    public int calculateConsonantStartingRate(String word, String... others) {
        int totalWords = 1 + others.length;
        int totalWordsStartingConsonant = 0;
        if (!checkIfWordStartsWithVowel(word)) {
            totalWordsStartingConsonant++;
        }

        for (String wordToCheck : others) {
            if (!checkIfWordStartsWithVowel(wordToCheck)) {
                totalWordsStartingConsonant++;
            }
        }
        return totalWordsStartingConsonant * 100 / totalWords;
    }

    public Boolean checkIfWordFinishesWithVowel(String word) {
        char[] wordArr = word.toLowerCase().toCharArray();
        if (wordArr[(wordArr.length - 1)] == 'a' || wordArr[(wordArr.length - 1)] == 'e' || wordArr[(wordArr.length - 1)] == 'i' || wordArr[(wordArr.length - 1)] == 'o' || wordArr[(wordArr.length - 1)] == 'u') {
            return true;
        }
        return false;
    }

    public int calculateFinishingWithVowelRate(String word, String... others) {
        int totalWords = 1 + others.length;
        int wordsFinishingWVowel = 0;
        if (checkIfWordFinishesWithVowel(word)) {
            wordsFinishingWVowel++;
        }
        for (String wordToCheck : others) {
            if (checkIfWordFinishesWithVowel(wordToCheck)) {
                wordsFinishingWVowel++;
            }
        }
        return wordsFinishingWVowel * 100 / totalWords;
    }

    public int calculateFinishingWithConsonantRate(String word, String... others) {
        int totalWords = 1 + others.length;
        int wordsFinishingWConsonant = 0;
        if (!checkIfWordFinishesWithVowel(word)) {
            wordsFinishingWConsonant++;
        }
        for (String wordToCheck : others) {
            if (!checkIfWordFinishesWithVowel(wordToCheck)) {
                wordsFinishingWConsonant++;
            }
        }
        return wordsFinishingWConsonant * 100 / totalWords;
    }

    public void improveResource(String word) {
        resources.put(word, resources.get(word) + 1);
    }

    public String discoverSomething(int percentChance) {
        Random random = new Random();
        String discovery = "";

        if (random.nextInt(1, 101) <= percentChance) {


            int whichOneToLevelUp = 0;
            int discoveryToLevelUp = random.nextInt(1, 6);
        /*
        Number from 1 to 5
        1=Technology
        2=Culture
        3=Faith
        4=Raw Materials
        5=Security
        */
            //Technology
            if (discoveryToLevelUp == 1) {
                if (resources.get("Technology") > 5 && discoveries.get("Computers") >= 1 && discoveries.get("Electricity") >= 1 && discoveries.get("Steam Power") >= 1 && discoveries.get("Writing") >= 1 && discoveries.get("Wheel") >= 1) {
                    whichOneToLevelUp = random.nextInt(1, 7);//1 to 6 Wheel,Writing,Steam Power, Electricity, Computers, Artificial Intelligence
                } else if (resources.get("Technology") == 5) {
                    whichOneToLevelUp = random.nextInt(1, 6);//1 to 5 Wheel,Writing,Steam Power, Electricity, Computers
                } else if (resources.get("Technology") == 4) {
                    whichOneToLevelUp = random.nextInt(1, 5);//1 to 4 Wheel,Writing,Steam Power, Electricity
                } else if (resources.get("Technology") == 3) {
                    whichOneToLevelUp = random.nextInt(1, 4);//1 to 3 Wheel,Writing,Steam Power
                } else if (resources.get("Technology") == 2) {
                    whichOneToLevelUp = random.nextInt(1, 3);//1 to 2 Wheel,Writing
                } else if (resources.get("Technology") == 1) {
                    whichOneToLevelUp = 1;
                }
                if (whichOneToLevelUp == 6) {
                    discovery = "Artificial Intelligence";
                } else if (whichOneToLevelUp == 5) {
                    discovery = "Computers";
                } else if (whichOneToLevelUp == 4) {
                    discovery = "Electricity";
                } else if (whichOneToLevelUp == 3) {
                    discovery = "Steam Power";
                } else if (whichOneToLevelUp == 2) {
                    discovery = "Writing";
                } else if (whichOneToLevelUp == 1) {
                    discovery = "Wheel";
                }

                if (!discovery.isEmpty()) {
                    discoveries.put(discovery, discoveries.get(discovery) + 1);
                }
            }
            // Cultura
            else if (discoveryToLevelUp == 2) {
                if (resources.get("Culture") >= 5 && discoveries.get("Art") >= 1 && discoveries.get("Philosophy") >= 1
                        && discoveries.get("Music") >= 1 && discoveries.get("Theater") >= 1 && discoveries.get("Sculpting") >= 1) {
                    whichOneToLevelUp = random.nextInt(1, 7); // 1 to 6 Art, Philosophy, Music, Theater, Sculpting, Renaissance
                } else if (resources.get("Culture") == 5) {
                    whichOneToLevelUp = random.nextInt(1, 6); // 1 to 5 Art, Philosophy, Music, Theater, Sculpting
                } else if (resources.get("Culture") == 4) {
                    whichOneToLevelUp = random.nextInt(1, 5); // 1 to 4 Art, Philosophy, Music, Theater
                } else if (resources.get("Culture") == 3) {
                    whichOneToLevelUp = random.nextInt(1, 4); // 1 to 3 Art, Philosophy, Music
                } else if (resources.get("Culture") == 2) {
                    whichOneToLevelUp = random.nextInt(1, 3); // 1 to 2 Art, Philosophy
                } else if (resources.get("Culture") == 1) {
                    whichOneToLevelUp = 1;
                }
                if (whichOneToLevelUp == 6) {
                    discovery = "Renaissance";
                } else if (whichOneToLevelUp == 5) {
                    discovery = "Sculpting";
                } else if (whichOneToLevelUp == 4) {
                    discovery = "Theater";
                } else if (whichOneToLevelUp == 3) {
                    discovery = "Music";
                } else if (whichOneToLevelUp == 2) {
                    discovery = "Philosophy";
                } else if (whichOneToLevelUp == 1) {
                    discovery = "Art";
                }

                if (!discovery.isEmpty()) {
                    discoveries.put(discovery, discoveries.get(discovery) + 1);
                }
            }

            // Fe
            else if (discoveryToLevelUp == 3) {
                if (resources.get("Faith") >= 5 && discoveries.get("Monotheism") >= 1 && discoveries.get("Polytheism") >= 1
                        && discoveries.get("Energies") >= 1 && discoveries.get("Divine Contact") >= 1 && discoveries.get("Enlightenment") >= 1) {
                    whichOneToLevelUp = random.nextInt(1, 7); // 1 to 6 Monotheism, Polytheism, Energies, Divine Contact, Enlightenment, New Creed
                } else if (resources.get("Faith") == 5) {
                    whichOneToLevelUp = random.nextInt(1, 6); // 1 to 5 Monotheism, Polytheism, Energies, Divine Contact, Enlightenment
                } else if (resources.get("Faith") == 4) {
                    whichOneToLevelUp = random.nextInt(1, 5); // 1 to 4 Monotheism, Polytheism, Energies, Divine Contact
                } else if (resources.get("Faith") == 3) {
                    whichOneToLevelUp = random.nextInt(1, 4); // 1 to 3 Monotheism, Polytheism, Energies
                } else if (resources.get("Faith") == 2) {
                    whichOneToLevelUp = random.nextInt(1, 3); // 1 to 2 Monotheism, Polytheism
                } else if (resources.get("Faith") == 1) {
                    whichOneToLevelUp = 1;
                }
                if (whichOneToLevelUp == 6) {
                    discovery = "Universal Faith";
                } else if (whichOneToLevelUp == 5) {
                    discovery = "Enlightenment";
                } else if (whichOneToLevelUp == 4) {
                    discovery = "Divine Contact";
                } else if (whichOneToLevelUp == 3) {
                    discovery = "Energies";
                } else if (whichOneToLevelUp == 2) {
                    discovery = "Polytheism";
                } else if (whichOneToLevelUp == 1) {
                    discovery = "Monotheism";
                }

                if (!discovery.isEmpty()) {
                    discoveries.put(discovery, discoveries.get(discovery) + 1);
                }
            }

            // Materiales
            else if (discoveryToLevelUp == 4) {
                if (resources.get("Raw Materials") >= 5 && discoveries.get("Copper") >= 1 && discoveries.get("Iron") >= 1
                        && discoveries.get("Coal") >= 1 && discoveries.get("Oil") >= 1 && discoveries.get("Rare Earth Elements") >= 1) {
                    whichOneToLevelUp = random.nextInt(1, 7); // 1 to 6 Copper, Iron, Coal, Oil, Rare Earth Elements, Nanomaterials
                } else if (resources.get("Raw Materials") == 5) {
                    whichOneToLevelUp = random.nextInt(1, 6); // 1 to 5 Copper, Iron, Coal, Oil, Rare Earth Elements
                } else if (resources.get("Raw Materials") == 4) {
                    whichOneToLevelUp = random.nextInt(1, 5); // 1 to 4 Copper, Iron, Coal, Oil
                } else if (resources.get("Raw Materials") == 3) {
                    whichOneToLevelUp = random.nextInt(1, 4); // 1 to 3 Copper, Iron, Coal
                } else if (resources.get("Raw Materials") == 2) {
                    whichOneToLevelUp = random.nextInt(1, 3); // 1 to 2 Copper, Iron
                } else if (resources.get("Raw Materials") == 1) {
                    whichOneToLevelUp = 1;
                }
                if (whichOneToLevelUp == 6) {
                    discovery = "Nuclear Fusion";
                } else if (whichOneToLevelUp == 5) {
                    discovery = "Rare Earth Elements";
                } else if (whichOneToLevelUp == 4) {
                    discovery = "Oil";
                } else if (whichOneToLevelUp == 3) {
                    discovery = "Coal";
                } else if (whichOneToLevelUp == 2) {
                    discovery = "Iron";
                } else if (whichOneToLevelUp == 1) {
                    discovery = "Copper";
                }

                if (!discovery.isEmpty()) {
                    discoveries.put(discovery, discoveries.get(discovery) + 1);
                }
            }

            // Seguridad
            else if (discoveryToLevelUp == 5) {
                if (resources.get("Security") >= 5 && discoveries.get("Basic Defense") >= 1 && discoveries.get("Archery") >= 1
                        && discoveries.get("Gunpowder") >= 1 && discoveries.get("Radar") >= 1 && discoveries.get("Invisibility") >= 1) {
                    whichOneToLevelUp = random.nextInt(1, 7); // 1 to 6 Basic Defense, Archery, Gunpowder, Radar, Invisibility, Cyber Defense
                } else if (resources.get("Security") == 5) {
                    whichOneToLevelUp = random.nextInt(1, 6); // 1 to 5 Basic Defense, Archery, Gunpowder, Radar, Invisibility
                } else if (resources.get("Security") == 4) {
                    whichOneToLevelUp = random.nextInt(1, 5); // 1 to 4 Basic Defense, Archery, Gunpowder, Radar
                } else if (resources.get("Security") == 3) {
                    whichOneToLevelUp = random.nextInt(1, 4); // 1 to 3 Basic Defense, Archery, Gunpowder
                } else if (resources.get("Security") == 2) {
                    whichOneToLevelUp = random.nextInt(1, 3); // 1 to 2 Basic Defense, Archery
                } else if (resources.get("Security") == 1) {
                    whichOneToLevelUp = 1;
                }
                if (whichOneToLevelUp == 6) {
                    discovery = "Cybersecurity";
                } else if (whichOneToLevelUp == 5) {
                    discovery = "Invisibility";
                } else if (whichOneToLevelUp == 4) {
                    discovery = "Radar";
                } else if (whichOneToLevelUp == 3) {
                    discovery = "Gunpowder";
                } else if (whichOneToLevelUp == 2) {
                    discovery = "Archery";
                } else if (whichOneToLevelUp == 1) {
                    discovery = "Basic Defense";
                }

                if (!discovery.isEmpty()) {
                    discoveries.put(discovery, discoveries.get(discovery) + 1);
                }
            }
            if (discoveries.get("Artificial Intelligence") >= 1 &&
                    discoveries.get("Renaissance") >= 1 &&
                    discoveries.get("Universal Faith") >= 1 &&
                    discoveries.get("Nuclear Fusion") >= 1 &&
                    discoveries.get("Cybersecurity") >= 1) {

                int randomChanceOfWinning = random.nextInt(1, 101);

                if (randomChanceOfWinning <= 5) { // 5% chance of winning
                    discovery = "World Domination";
                    discoveries.put(discovery, 1);
                }
            }
            logEventDiscovery(discovery);

        } else {
            discovery = "The Civilization has not discovered anything";
        }
        if (!discovery.isEmpty()) {
            if (discoveries.get(discovery) == 1) {
                return "The Civilization has discovered " + discovery + " " + getDiscoveries().get(discovery);
            } else {
                return "The Civilization has improved their " + discovery + ", now they have " + discovery + " " + getDiscoveries().get(discovery);
            }
        } else {
            discovery = "The Civilization has not discovered anything";
        }
        return discovery;
    }

    public void logEventDiscovery(String discovery) {
        if (!discovery.isEmpty()) {
            if (discoveries.get(discovery) <= 1) {
                eventsLog.add("Year " + age + ": The " + name + " people has discovered the " + discovery.toLowerCase() + ", " + discovery + " is now Level " + discoveries.get(discovery));
            } else {
                eventsLog.add("Year " + age + ": The " + name + " people has improved their " + discovery.toLowerCase() + ", " + discovery + " is now Level " + discoveries.get(discovery));
            }
        }
    }

    public String learningResource(int percentChance) {
        Random random = new Random();
        String resourceToImprove = "";
        if (random.nextInt(1, 101) < percentChance) {
            int whatIsLearning = random.nextInt(1, 6);//1 Technology 2 Culture 3 Faith 4 Raw Materials 5 Security
            if (whatIsLearning == 1) {
                resourceToImprove = "Technology";
                improveResource(resourceToImprove);
            } else if (whatIsLearning == 2) {
                resourceToImprove = "Culture";
                improveResource(resourceToImprove);
            } else if (whatIsLearning == 3) {
                resourceToImprove = "Faith";
                improveResource(resourceToImprove);
            } else if (whatIsLearning == 4) {
                resourceToImprove = "Raw Materials";
                improveResource(resourceToImprove);
            } else if (whatIsLearning == 5) {
                resourceToImprove = "Security";
                improveResource(resourceToImprove);
            }
            if (!resourceToImprove.isEmpty()) {
                logEventResource(resourceToImprove);
            }
            if (resources.get(resourceToImprove) == 1) {
                return "The Civilization has discovered " + resourceToImprove + " 1";
            } else {
                return "The Civilization has improved their " + resourceToImprove + ", now they have " + resourceToImprove + " " + getResources().get(resourceToImprove);
            }
        }
        return resourceToImprove;
    }

    @Override
    public String toString() {
        return "Civilization{" +
                "attempts=" + attempts +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", resources=" + getResources() +
                ", discoveries=" + getDiscoveries() +
                ", population=" + population +
                ", importantIndividuals=" + importantIndividuals +
                ", eventsLog=" + eventsLog +
                ", languagePatterns=" + languagePatterns +
                '}';
    }
}
