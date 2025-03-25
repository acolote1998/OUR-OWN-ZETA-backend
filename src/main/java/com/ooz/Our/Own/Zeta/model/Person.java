package com.ooz.Our.Own.Zeta.model;

import java.util.*;

public class Person {
    int age;
    String name;
    String field;
    Map<String, Integer> discoveries = new HashMap<>();//<Name of Discovery, Tier>
    boolean alive;
    int knowledge;
    List<String> lifeLog = new ArrayList<>();

    public List<String> getLifeLog() {
        return lifeLog;
    }

    public void setLifeLog(List<String> lifeLog) {
        this.lifeLog = lifeLog;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Map<String, Integer> getDiscoveries() {
        Map<String, Integer> discoveriesNotZer = new HashMap<>();
        for (Map.Entry<String, Integer> discovery : discoveries.entrySet()) {
            if (discovery.getValue() > 0) {
                discoveriesNotZer.put(discovery.getKey(), discovery.getValue());
            }
        }
        return discoveriesNotZer;
    }

    public void setDiscoveries(Map<String, Integer> discoveries) {
        this.discoveries = discoveries;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public Person(int age, String name, String field, Map<String, Integer> discoveries, boolean alive, int knowledge, List<String> lifeLog) {
        this.age = age;
        this.name = name;
        this.field = field;
        this.discoveries = discoveries;
        this.alive = alive;
        this.knowledge = knowledge;
        this.lifeLog = lifeLog;

        // ARTIST DISCOVERIES
        discoveries.put("Painting", 0); // 1 - Tier 1
        discoveries.put("Music", 0); // 2 - Tier 1
        discoveries.put("Acting", 0); // 3 - Tier 1
        discoveries.put("Collage", 0); // 4 - Tier 1
        discoveries.put("Drawing", 0); // 5 - Tier 1

        discoveries.put("Oil Painting", 0); // 6 - Tier 2
        discoveries.put("Music Theory", 0); // 7 - Tier 2
        discoveries.put("Modern Dance", 0); // 8 - Tier 2
        discoveries.put("Acting Techniques", 0); // 9 - Tier 2
        discoveries.put("Digital Art", 0); // 10 - Tier 2

        discoveries.put("Watercolor", 0); // 11 - Tier 3
        discoveries.put("Composing Music", 0); // 12 - Tier 3
        discoveries.put("Film Acting", 0); // 13 - Tier 3
        discoveries.put("Sculpture", 0); // 14 - Tier 3
        discoveries.put("Interactive Installation", 0); // 15 - Tier 3

        discoveries.put("Acrylic Painting", 0); // 16 - Tier 4
        discoveries.put("Advanced Music", 0); // 17 - Tier 4
        discoveries.put("Theatre Performance", 0); // 18 - Tier 4
        discoveries.put("Multimedia Art", 0); // 19 - Tier 4
        discoveries.put("Experimental Theatre", 0); // 20 - Tier 4

        discoveries.put("Conceptual Art", 0); // 21 - Tier 5
        discoveries.put("Music Direction", 0); // 22 - Tier 5
        discoveries.put("Experimental Music", 0); // 23 - Tier 5
        discoveries.put("Solo Art Exhibition", 0); // 24 - Tier 5
        discoveries.put("Live Performance", 0); // 25 - Tier 5

// ATHLETE
        discoveries.put("Endurance", 0); // 1 - Tier 1
        discoveries.put("Speed", 0); // 2 - Tier 1
        discoveries.put("Strength", 0); // 3 - Tier 1
        discoveries.put("Agility", 0); // 4 - Tier 1
        discoveries.put("Flexibility", 0); // 5 - Tier 1

        discoveries.put("Cardio Training", 0); // 6 - Tier 2
        discoveries.put("Muscle Building", 0); // 7 - Tier 2
        discoveries.put("Balance", 0); // 8 - Tier 2
        discoveries.put("Coordination", 0); // 9 - Tier 2
        discoveries.put("Sprint Training", 0); // 10 - Tier 2

        discoveries.put("Speed Endurance", 0); // 11 - Tier 3
        discoveries.put("Explosive Power", 0); // 12 - Tier 3
        discoveries.put("Core Strength", 0); // 13 - Tier 3
        discoveries.put("Mental Toughness", 0); // 14 - Tier 3
        discoveries.put("Recovery Techniques", 0); // 15 - Tier 3

        discoveries.put("High-Intensity Training", 0); // 16 - Tier 4
        discoveries.put("Power Development", 0); // 17 - Tier 4
        discoveries.put("Mobility", 0); // 18 - Tier 4
        discoveries.put("Reaction Time", 0); // 19 - Tier 4
        discoveries.put("Performance Optimization", 0); // 20 - Tier 4

        discoveries.put("Elite Strength", 0); // 21 - Tier 5
        discoveries.put("Advanced Agility", 0); // 22 - Tier 5
        discoveries.put("Maximal Speed", 0); // 23 - Tier 5
        discoveries.put("Body Control", 0); // 24 - Tier 5
        discoveries.put("Sports Psychology", 0); // 25 - Tier 5

// DOCTOR
        discoveries.put("Anatomy", 0); // 1 - Tier 1
        discoveries.put("Physiology", 0); // 2 - Tier 1
        discoveries.put("Diagnosis", 0); // 3 - Tier 1
        discoveries.put("Medical Ethics", 0); // 4 - Tier 1
        discoveries.put("Pharmacology", 0); // 5 - Tier 1

        discoveries.put("Clinical Examination", 0); // 6 - Tier 2
        discoveries.put("Medical Research", 0); // 7 - Tier 2
        discoveries.put("Surgical Techniques", 0); // 8 - Tier 2
        discoveries.put("Patient Care", 0); // 9 - Tier 2
        discoveries.put("Medical Imaging", 0); // 10 - Tier 2

        discoveries.put("Pathology", 0); // 11 - Tier 3
        discoveries.put("Advanced Diagnosis", 0); // 12 - Tier 3
        discoveries.put("Medical Interventions", 0); // 13 - Tier 3
        discoveries.put("Emergency Care", 0); // 14 - Tier 3
        discoveries.put("Preventive Medicine", 0); // 15 - Tier 3

        discoveries.put("Critical Care", 0); // 16 - Tier 4
        discoveries.put("Neurology", 0); // 17 - Tier 4
        discoveries.put("Pharmacogenomics", 0); // 18 - Tier 4
        discoveries.put("Neurobiology", 0); // 19 - Tier 4
        discoveries.put("Medical Innovations", 0); // 20 - Tier 4

        discoveries.put("Medical Leadership", 0); // 21 - Tier 5
        discoveries.put("Surgical Mastery", 0); // 22 - Tier 5
        discoveries.put("Rehabilitation Medicine", 0); // 23 - Tier 5
        discoveries.put("Global Health", 0); // 24 - Tier 5
        discoveries.put("Medical Education", 0); // 25 - Tier 5

// SCIENTIST
        discoveries.put("Scientific Method", 0); // 1 - Tier 1
        discoveries.put("Research", 0); // 2 - Tier 1
        discoveries.put("Data Analysis", 0); // 3 - Tier 1
        discoveries.put("Hypothesis Testing", 0); // 4 - Tier 1
        discoveries.put("Experimentation", 0); // 5 - Tier 1

        discoveries.put("Mathematics", 0); // 6 - Tier 2
        discoveries.put("Chemistry", 0); // 7 - Tier 2
        discoveries.put("Physics", 0); // 8 - Tier 2
        discoveries.put("Biology", 0); // 9 - Tier 2
        discoveries.put("Lab Management", 0); // 10 - Tier 2

        discoveries.put("Advanced Research", 0); // 11 - Tier 3
        discoveries.put("Innovative Thinking", 0); // 12 - Tier 3
        discoveries.put("Quantitative Analysis", 0); // 13 - Tier 3
        discoveries.put("Laboratory Techniques", 0); // 14 - Tier 3
        discoveries.put("Theoretical Modeling", 0); // 15 - Tier 3

        discoveries.put("Innovation", 0); // 16 - Tier 4
        discoveries.put("Genetics", 0); // 17 - Tier 4
        discoveries.put("Nanotechnology", 0); // 18 - Tier 4
        discoveries.put("Artificial Intelligence", 0); // 19 - Tier 4
        discoveries.put("Scientific Communication", 0); // 20 - Tier 4

        discoveries.put("Grant Writing", 0); // 21 - Tier 5
        discoveries.put("Project Management", 0); // 22 - Tier 5
        discoveries.put("Field Research", 0); // 23 - Tier 5
        discoveries.put("Data Interpretation", 0); // 24 - Tier 5
        discoveries.put("Scientific Mentorship", 0); // 25 - Tier 5

    }

    public String discoverSomething(int chanceOfLearning) {
        String discovered = "";
        Random random = new Random();
        if (random.nextInt(1, 101) <= chanceOfLearning) {
            int whatAreWeLearning = 0;
            if (knowledge >= 80) {//Can learn Tier 5
                whatAreWeLearning = random.nextInt(1, 26);
            } else if (knowledge >= 60) {//Can learn Tier 4
                whatAreWeLearning = random.nextInt(1, 21);
            } else if (knowledge >= 40) {//Can learn Tier 3
                whatAreWeLearning = random.nextInt(1, 16);
            } else if (knowledge >= 20) {//Can learn Tier 2
                whatAreWeLearning = random.nextInt(1, 11);
            } else if (knowledge >= 0) {//Can learn Tier 1
                whatAreWeLearning = random.nextInt(1, 6);
            }
            switch (field) {
                case "Artist":
                    discovered = switch (whatAreWeLearning) {
                        // ARTIST DISCOVERIES
                        case 1 -> {
                            discoveries.put("Painting", discoveries.get("Painting") + 1); // 1 - Tier 1
                            yield "Painting " + discoveries.get("Painting");
                        }
                        case 2 -> {
                            discoveries.put("Music", discoveries.get("Music") + 1); // 2 - Tier 1
                            yield "Music " + discoveries.get("Music");
                        }
                        case 3 -> {
                            discoveries.put("Acting", discoveries.get("Acting") + 1); // 3 - Tier 1
                            yield "Acting " + discoveries.get("Acting");
                        }
                        case 4 -> {
                            discoveries.put("Collage", discoveries.get("Collage") + 1); // 4 - Tier 1
                            yield "Collage " + discoveries.get("Collage");
                        }
                        case 5 -> {
                            discoveries.put("Drawing", discoveries.get("Drawing") + 1); // 5 - Tier 1
                            yield "Drawing " + discoveries.get("Drawing");
                        }
                        case 6 -> {
                            discoveries.put("Oil Painting", discoveries.get("Oil Painting") + 1); // 6 - Tier 2
                            yield "Oil Painting " + discoveries.get("Oil Painting");
                        }
                        case 7 -> {
                            discoveries.put("Music Theory", discoveries.get("Music Theory") + 1); // 7 - Tier 2
                            yield "Music Theory " + discoveries.get("Music Theory");
                        }
                        case 8 -> {
                            discoveries.put("Modern Dance", discoveries.get("Modern Dance") + 1); // 8 - Tier 2
                            yield "Modern Dance " + discoveries.get("Modern Dance");
                        }
                        case 9 -> {
                            discoveries.put("Acting Techniques", discoveries.get("Acting Techniques") + 1); // 9 - Tier 2
                            yield "Acting Techniques " + discoveries.get("Acting Techniques");
                        }
                        case 10 -> {
                            discoveries.put("Digital Art", discoveries.get("Digital Art") + 1); // 10 - Tier 2
                            yield "Digital Art " + discoveries.get("Digital Art");
                        }
                        case 11 -> {
                            discoveries.put("Watercolor", discoveries.get("Watercolor") + 1); // 11 - Tier 3
                            yield "Watercolor " + discoveries.get("Watercolor");
                        }
                        case 12 -> {
                            discoveries.put("Composing Music", discoveries.get("Composing Music") + 1); // 12 - Tier 3
                            yield "Composing Music " + discoveries.get("Composing Music");
                        }
                        case 13 -> {
                            discoveries.put("Film Acting", discoveries.get("Film Acting") + 1); // 13 - Tier 3
                            yield "Film Acting " + discoveries.get("Film Acting");
                        }
                        case 14 -> {
                            discoveries.put("Sculpture", discoveries.get("Sculpture") + 1); // 14 - Tier 3
                            yield "Sculpture " + discoveries.get("Sculpture");
                        }
                        case 15 -> {
                            discoveries.put("Interactive Installation", discoveries.get("Interactive Installation") + 1); // 15 - Tier 3
                            yield "Interactive Installation " + discoveries.get("Interactive Installation");
                        }
                        case 16 -> {
                            discoveries.put("Acrylic Painting", discoveries.get("Acrylic Painting") + 1); // 16 - Tier 4
                            yield "Acrylic Painting " + discoveries.get("Acrylic Painting");
                        }
                        case 17 -> {
                            discoveries.put("Advanced Music", discoveries.get("Advanced Music") + 1); // 17 - Tier 4
                            yield "Advanced Music " + discoveries.get("Advanced Music");
                        }
                        case 18 -> {
                            discoveries.put("Theatre Performance", discoveries.get("Theatre Performance") + 1); // 18 - Tier 4
                            yield "Theatre Performance " + discoveries.get("Theatre Performance");
                        }
                        case 19 -> {
                            discoveries.put("Multimedia Art", discoveries.get("Multimedia Art") + 1); // 19 - Tier 4
                            yield "Multimedia Art " + discoveries.get("Multimedia Art");
                        }
                        case 20 -> {
                            discoveries.put("Experimental Theatre", discoveries.get("Experimental Theatre") + 1); // 20 - Tier 4
                            yield "Experimental Theatre " + discoveries.get("Experimental Theatre");
                        }
                        case 21 -> {
                            discoveries.put("Conceptual Art", discoveries.get("Conceptual Art") + 1); // 21 - Tier 5
                            yield "Conceptual Art " + discoveries.get("Conceptual Art");
                        }
                        case 22 -> {
                            discoveries.put("Music Direction", discoveries.get("Music Direction") + 1); // 22 - Tier 5
                            yield "Music Direction " + discoveries.get("Music Direction");
                        }
                        case 23 -> {
                            discoveries.put("Experimental Music", discoveries.get("Experimental Music") + 1); // 23 - Tier 5
                            yield "Experimental Music " + discoveries.get("Experimental Music");
                        }
                        case 24 -> {
                            discoveries.put("Solo Art Exhibition", discoveries.get("Solo Art Exhibition") + 1); // 24 - Tier 5
                            yield "Solo Art Exhibition " + discoveries.get("Solo Art Exhibition");
                        }
                        case 25 -> {
                            discoveries.put("Live Performance", discoveries.get("Live Performance") + 1); // 25 - Tier 5
                            yield "Live Performance " + discoveries.get("Live Performance");
                        }
                        default -> discovered;
                    };
                    break;
                case "Athlete":
                    discovered = switch (whatAreWeLearning) {
                        // ATHLETE DISCOVERIES
                        case 1 -> {
                            discoveries.put("Endurance", discoveries.get("Endurance") + 1); // 1 - Tier 1
                            yield "Endurance " + discoveries.get("Endurance");
                        }
                        case 2 -> {
                            discoveries.put("Speed", discoveries.get("Speed") + 1); // 2 - Tier 1
                            yield "Speed " + discoveries.get("Speed");
                        }
                        case 3 -> {
                            discoveries.put("Strength", discoveries.get("Strength") + 1); // 3 - Tier 1
                            yield "Strength " + discoveries.get("Strength");
                        }
                        case 4 -> {
                            discoveries.put("Agility", discoveries.get("Agility") + 1); // 4 - Tier 1
                            yield "Agility " + discoveries.get("Agility");
                        }
                        case 5 -> {
                            discoveries.put("Flexibility", discoveries.get("Flexibility") + 1); // 5 - Tier 1
                            yield "Flexibility " + discoveries.get("Flexibility");
                        }
                        case 6 -> {
                            discoveries.put("Cardio Training", discoveries.get("Cardio Training") + 1); // 6 - Tier 2
                            yield "Cardio Training " + discoveries.get("Cardio Training");
                        }
                        case 7 -> {
                            discoveries.put("Muscle Building", discoveries.get("Muscle Building") + 1); // 7 - Tier 2
                            yield "Muscle Building " + discoveries.get("Muscle Building");
                        }
                        case 8 -> {
                            discoveries.put("Balance", discoveries.get("Balance") + 1); // 8 - Tier 2
                            yield "Balance " + discoveries.get("Balance");
                        }
                        case 9 -> {
                            discoveries.put("Coordination", discoveries.get("Coordination") + 1); // 9 - Tier 2
                            yield "Coordination " + discoveries.get("Coordination");
                        }
                        case 10 -> {
                            discoveries.put("Sprint Training", discoveries.get("Sprint Training") + 1); // 10 - Tier 2
                            yield "Sprint Training " + discoveries.get("Sprint Training");
                        }
                        case 11 -> {
                            discoveries.put("Speed Endurance", discoveries.get("Speed Endurance") + 1); // 11 - Tier 3
                            yield "Speed Endurance " + discoveries.get("Speed Endurance");
                        }
                        case 12 -> {
                            discoveries.put("Explosive Power", discoveries.get("Explosive Power") + 1); // 12 - Tier 3
                            yield "Explosive Power " + discoveries.get("Explosive Power");
                        }
                        case 13 -> {
                            discoveries.put("Core Strength", discoveries.get("Core Strength") + 1); // 13 - Tier 3
                            yield "Core Strength " + discoveries.get("Core Strength");
                        }
                        case 14 -> {
                            discoveries.put("Mental Toughness", discoveries.get("Mental Toughness") + 1); // 14 - Tier 3
                            yield "Mental Toughness " + discoveries.get("Mental Toughness");
                        }
                        case 15 -> {
                            discoveries.put("Recovery Techniques", discoveries.get("Recovery Techniques") + 1); // 15 - Tier 3
                            yield "Recovery Techniques " + discoveries.get("Recovery Techniques");
                        }
                        case 16 -> {
                            discoveries.put("High-Intensity Training", discoveries.get("High-Intensity Training") + 1); // 16 - Tier 4
                            yield "High-Intensity Training " + discoveries.get("High-Intensity Training");
                        }
                        case 17 -> {
                            discoveries.put("Power Development", discoveries.get("Power Development") + 1); // 17 - Tier 4
                            yield "Power Development " + discoveries.get("Power Development");
                        }
                        case 18 -> {
                            discoveries.put("Mobility", discoveries.get("Mobility") + 1); // 18 - Tier 4
                            yield "Mobility " + discoveries.get("Mobility");
                        }
                        case 19 -> {
                            discoveries.put("Reaction Time", discoveries.get("Reaction Time") + 1); // 19 - Tier 4
                            yield "Reaction Time " + discoveries.get("Reaction Time");
                        }
                        case 20 -> {
                            discoveries.put("Performance Optimization", discoveries.get("Performance Optimization") + 1); // 20 - Tier 4
                            yield "Performance Optimization " + discoveries.get("Performance Optimization");
                        }
                        case 21 -> {
                            discoveries.put("Elite Strength", discoveries.get("Elite Strength") + 1); // 21 - Tier 5
                            yield "Elite Strength " + discoveries.get("Elite Strength");
                        }
                        case 22 -> {
                            discoveries.put("Advanced Agility", discoveries.get("Advanced Agility") + 1); // 22 - Tier 5
                            yield "Advanced Agility " + discoveries.get("Advanced Agility");
                        }
                        case 23 -> {
                            discoveries.put("Maximal Speed", discoveries.get("Maximal Speed") + 1); // 23 - Tier 5
                            yield "Maximal Speed " + discoveries.get("Maximal Speed");
                        }
                        case 24 -> {
                            discoveries.put("Body Control", discoveries.get("Body Control") + 1); // 24 - Tier 5
                            yield "Body Control " + discoveries.get("Body Control");
                        }
                        case 25 -> {
                            discoveries.put("Sports Psychology", discoveries.get("Sports Psychology") + 1); // 25 - Tier 5
                            yield "Sports Psychology " + discoveries.get("Sports Psychology");
                        }
                        default -> discovered;
                    };
                    break;
                case "Doctor":
                    discovered = switch (whatAreWeLearning) {
                        // DOCTOR DISCOVERIES
                        case 1 -> {
                            discoveries.put("Anatomy", discoveries.get("Anatomy") + 1); // 1 - Tier 1
                            yield "Anatomy " + discoveries.get("Anatomy");
                        }
                        case 2 -> {
                            discoveries.put("Physiology", discoveries.get("Physiology") + 1); // 2 - Tier 1
                            yield "Physiology " + discoveries.get("Physiology");
                        }
                        case 3 -> {
                            discoveries.put("Diagnosis", discoveries.get("Diagnosis") + 1); // 3 - Tier 1
                            yield "Diagnosis " + discoveries.get("Diagnosis");
                        }
                        case 4 -> {
                            discoveries.put("Medical Ethics", discoveries.get("Medical Ethics") + 1); // 4 - Tier 1
                            yield "Medical Ethics " + discoveries.get("Medical Ethics");
                        }
                        case 5 -> {
                            discoveries.put("Pharmacology", discoveries.get("Pharmacology") + 1); // 5 - Tier 1
                            yield "Pharmacology " + discoveries.get("Pharmacology");
                        }
                        case 6 -> {
                            discoveries.put("Clinical Examination", discoveries.get("Clinical Examination") + 1); // 6 - Tier 2
                            yield "Clinical Examination " + discoveries.get("Clinical Examination");
                        }
                        case 7 -> {
                            discoveries.put("Medical Research", discoveries.get("Medical Research") + 1); // 7 - Tier 2
                            yield "Medical Research " + discoveries.get("Medical Research");
                        }
                        case 8 -> {
                            discoveries.put("Surgical Techniques", discoveries.get("Surgical Techniques") + 1); // 8 - Tier 2
                            yield "Surgical Techniques " + discoveries.get("Surgical Techniques");
                        }
                        case 9 -> {
                            discoveries.put("Patient Care", discoveries.get("Patient Care") + 1); // 9 - Tier 2
                            yield "Patient Care " + discoveries.get("Patient Care");
                        }
                        case 10 -> {
                            discoveries.put("Medical Imaging", discoveries.get("Medical Imaging") + 1); // 10 - Tier 2
                            yield "Medical Imaging " + discoveries.get("Medical Imaging");
                        }
                        case 11 -> {
                            discoveries.put("Pathology", discoveries.get("Pathology") + 1); // 11 - Tier 3
                            yield "Pathology " + discoveries.get("Pathology");
                        }
                        case 12 -> {
                            discoveries.put("Advanced Diagnosis", discoveries.get("Advanced Diagnosis") + 1); // 12 - Tier 3
                            yield "Advanced Diagnosis " + discoveries.get("Advanced Diagnosis");
                        }
                        case 13 -> {
                            discoveries.put("Medical Interventions", discoveries.get("Medical Interventions") + 1); // 13 - Tier 3
                            yield "Medical Interventions " + discoveries.get("Medical Interventions");
                        }
                        case 14 -> {
                            discoveries.put("Emergency Care", discoveries.get("Emergency Care") + 1); // 14 - Tier 3
                            yield "Emergency Care " + discoveries.get("Emergency Care");
                        }
                        case 15 -> {
                            discoveries.put("Preventive Medicine", discoveries.get("Preventive Medicine") + 1); // 15 - Tier 3
                            yield "Preventive Medicine " + discoveries.get("Preventive Medicine");
                        }
                        case 16 -> {
                            discoveries.put("Critical Care", discoveries.get("Critical Care") + 1); // 16 - Tier 4
                            yield "Critical Care " + discoveries.get("Critical Care");
                        }
                        case 17 -> {
                            discoveries.put("Neurology", discoveries.get("Neurology") + 1); // 17 - Tier 4
                            yield "Neurology " + discoveries.get("Neurology");
                        }
                        case 18 -> {
                            discoveries.put("Pharmacogenomics", discoveries.get("Pharmacogenomics") + 1); // 18 - Tier 4
                            yield "Pharmacogenomics " + discoveries.get("Pharmacogenomics");
                        }
                        case 19 -> {
                            discoveries.put("Neurobiology", discoveries.get("Neurobiology") + 1); // 19 - Tier 4
                            yield "Neurobiology " + discoveries.get("Neurobiology");
                        }
                        case 20 -> {
                            discoveries.put("Medical Innovations", discoveries.get("Medical Innovations") + 1); // 20 - Tier 4
                            yield "Medical Innovations " + discoveries.get("Medical Innovations");
                        }
                        case 21 -> {
                            discoveries.put("Medical Leadership", discoveries.get("Medical Leadership") + 1); // 21 - Tier 5
                            yield "Medical Leadership " + discoveries.get("Medical Leadership");
                        }
                        case 22 -> {
                            discoveries.put("Surgical Mastery", discoveries.get("Surgical Mastery") + 1); // 22 - Tier 5
                            yield "Surgical Mastery " + discoveries.get("Surgical Mastery");
                        }
                        case 23 -> {
                            discoveries.put("Rehabilitation Medicine", discoveries.get("Rehabilitation Medicine") + 1); // 23 - Tier 5
                            yield "Rehabilitation Medicine " + discoveries.get("Rehabilitation Medicine");
                        }
                        case 24 -> {
                            discoveries.put("Global Health", discoveries.get("Global Health") + 1); // 24 - Tier 5
                            yield "Global Health " + discoveries.get("Global Health");
                        }
                        case 25 -> {
                            discoveries.put("Medical Education", discoveries.get("Medical Education") + 1); // 25 - Tier 5
                            yield "Medical Education " + discoveries.get("Medical Education");
                        }
                        default -> discovered;
                    };
                    break;
                case "Scientist":
                    discovered = switch (whatAreWeLearning) {
                        // SCIENTIST DISCOVERIES
                        case 1 -> {
                            discoveries.put("Scientific Method", discoveries.get("Scientific Method") + 1); // 1 - Tier 1
                            yield "Scientific Method " + discoveries.get("Scientific Method");
                        }
                        case 2 -> {
                            discoveries.put("Research", discoveries.get("Research") + 1); // 2 - Tier 1
                            yield "Research " + discoveries.get("Research");
                        }
                        case 3 -> {
                            discoveries.put("Data Analysis", discoveries.get("Data Analysis") + 1); // 3 - Tier 1
                            yield "Data Analysis " + discoveries.get("Data Analysis");
                        }
                        case 4 -> {
                            discoveries.put("Hypothesis Testing", discoveries.get("Hypothesis Testing") + 1); // 4 - Tier 1
                            yield "Hypothesis Testing " + discoveries.get("Hypothesis Testing");
                        }
                        case 5 -> {
                            discoveries.put("Experimentation", discoveries.get("Experimentation") + 1); // 5 - Tier 1
                            yield "Experimentation " + discoveries.get("Experimentation");
                        }
                        case 6 -> {
                            discoveries.put("Mathematics", discoveries.get("Mathematics") + 1); // 6 - Tier 2
                            yield "Mathematics " + discoveries.get("Mathematics");
                        }
                        case 7 -> {
                            discoveries.put("Chemistry", discoveries.get("Chemistry") + 1); // 7 - Tier 2
                            yield "Chemistry " + discoveries.get("Chemistry");
                        }
                        case 8 -> {
                            discoveries.put("Physics", discoveries.get("Physics") + 1); // 8 - Tier 2
                            yield "Physics " + discoveries.get("Physics");
                        }
                        case 9 -> {
                            discoveries.put("Biology", discoveries.get("Biology") + 1); // 9 - Tier 2
                            yield "Biology " + discoveries.get("Biology");
                        }
                        case 10 -> {
                            discoveries.put("Lab Management", discoveries.get("Lab Management") + 1); // 10 - Tier 2
                            yield "Lab Management " + discoveries.get("Lab Management");
                        }
                        case 11 -> {
                            discoveries.put("Advanced Research", discoveries.get("Advanced Research") + 1); // 11 - Tier 3
                            yield "Advanced Research " + discoveries.get("Advanced Research");
                        }
                        case 12 -> {
                            discoveries.put("Innovative Thinking", discoveries.get("Innovative Thinking") + 1); // 12 - Tier 3
                            yield "Innovative Thinking " + discoveries.get("Innovative Thinking");
                        }
                        case 13 -> {
                            discoveries.put("Quantitative Analysis", discoveries.get("Quantitative Analysis") + 1); // 13 - Tier 3
                            yield "Quantitative Analysis " + discoveries.get("Quantitative Analysis");
                        }
                        case 14 -> {
                            discoveries.put("Laboratory Techniques", discoveries.get("Laboratory Techniques") + 1); // 14 - Tier 3
                            yield "Laboratory Techniques " + discoveries.get("Laboratory Techniques");
                        }
                        case 15 -> {
                            discoveries.put("Theoretical Modeling", discoveries.get("Theoretical Modeling") + 1); // 15 - Tier 3
                            yield "Theoretical Modeling " + discoveries.get("Theoretical Modeling");
                        }
                        case 16 -> {
                            discoveries.put("Innovation", discoveries.get("Innovation") + 1); // 16 - Tier 4
                            yield "Innovation " + discoveries.get("Innovation");
                        }
                        case 17 -> {
                            discoveries.put("Genetics", discoveries.get("Genetics") + 1); // 17 - Tier 4
                            yield "Genetics " + discoveries.get("Genetics");
                        }
                        case 18 -> {
                            discoveries.put("Nanotechnology", discoveries.get("Nanotechnology") + 1); // 18 - Tier 4
                            yield "Nanotechnology " + discoveries.get("Nanotechnology");
                        }
                        case 19 -> {
                            discoveries.put("Artificial Intelligence", discoveries.get("Artificial Intelligence") + 1); // 19 - Tier 4
                            yield "Artificial Intelligence " + discoveries.get("Artificial Intelligence");
                        }
                        case 20 -> {
                            discoveries.put("Scientific Communication", discoveries.get("Scientific Communication") + 1); // 20 - Tier 4
                            yield "Scientific Communication " + discoveries.get("Scientific Communication");
                        }
                        case 21 -> {
                            discoveries.put("Grant Writing", discoveries.get("Grant Writing") + 1); // 21 - Tier 5
                            yield "Grant Writing " + discoveries.get("Grant Writing");
                        }
                        case 22 -> {
                            discoveries.put("Project Management", discoveries.get("Project Management") + 1); // 22 - Tier 5
                            yield "Project Management " + discoveries.get("Project Management");
                        }
                        case 23 -> {
                            discoveries.put("Field Research", discoveries.get("Field Research") + 1); // 23 - Tier 5
                            yield "Field Research " + discoveries.get("Field Research");
                        }
                        case 24 -> {
                            discoveries.put("Data Interpretation", discoveries.get("Data Interpretation") + 1); // 24 - Tier 5
                            yield "Data Interpretation " + discoveries.get("Data Interpretation");
                        }
                        case 25 -> {
                            discoveries.put("Scientific Mentorship", discoveries.get("Scientific Mentorship") + 1); // 25 - Tier 5
                            yield "Scientific Mentorship " + discoveries.get("Scientific Mentorship");
                        }
                        default -> discovered;
                    };
                    break;
            }
            knowledge += random.nextInt(1, 26);
            lifeLog.add("At " + age + " years old, " + name + " has now " + discovered + "!");
            return name + " has now " + discovered + "!";

        } else {
            return "Person not found";
        }

    }

    public void passManyYears(int years) {

        for (int i = 0; i < years; i++) {
            if (alive) {
                pasOneYear();
            }
        }
    }

    public void pasOneYear() {
        this.age += 1;
        Random random = new Random();
        if (age >= 100) {
            if (random.nextInt(1, 101) <= 35) {
                passAway();
            }
        } else if (age > 90) {
            if (random.nextInt(1, 101) <= 25) {
                passAway();
            }
        } else if (age > 80) {
            if (random.nextInt(1, 101) <= 10) {
                passAway();
            }
        } else if (age > 70) {
            if (random.nextInt(1, 101) <= 4) {
                passAway();
            }
        } else if (age > 60) {
            if (random.nextInt(1, 101) <= 3) {
                passAway();
            }
        } else if (age > 40) {
            if (random.nextInt(1, 101) <= 2) {
                passAway();
            }
        } else if (age > 20) {
            if (random.nextInt(1, 101) <= 1) {
                passAway();
            }
        }
        discoverSomething(5 + (5 * knowledge / 100)); // Chances of discovering something is 5% + 5% of their knowledge
    }

    public String passAway() {
        this.alive = false;
        String message = name + " has passed away at the age of " + age;
        lifeLog.add(message);
        return message;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", field='" + field + '\'' +
                ", discoveries=" + getDiscoveries() +
                ", alive=" + alive +
                ", knowledge=" + knowledge +
                ", lifeLog=" + lifeLog +
                '}';
    }

}