package com.ooz.Our.Own.Zeta.controller;

import com.ooz.Our.Own.Zeta.model.Civilization;
import com.ooz.Our.Own.Zeta.model.Person;
import net.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CivilizationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
        //@Order(1)
    void gettingCivilizationThatDoesNotExist() {
        // Llamada a la API con un nombre que no existe
        ResponseEntity<String> response = restTemplate.getForEntity("/civilizations/Aztecs", String.class);

        // Verificar que la respuesta sea un error 500
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

        // Opcional: Verificar que el cuerpo de la respuesta contenga un mensaje de error
        //System.out.println(response.getBody());
        assertTrue(response.getBody().contains("Civilization not found"));
    }

    @Test
    void getACivlization() {
        String[] wordsToFeed = new String[]{"Manuel", "Miguel", "Mandela"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordsToFeed, Map.class);
        ResponseEntity<Civilization> response = restTemplate.postForEntity("/civilizations", null, Civilization.class);
        String nameOfCreated = response.getBody().getName();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
        ResponseEntity<Civilization> responseCivilization = restTemplate.getForEntity("/civilizations/" + nameOfCreated, Civilization.class);
        assertEquals(HttpStatus.OK, responseCivilization.getStatusCode());
        assertFalse(responseCivilization.getBody().getName().isEmpty());
    }


    @Test
    void createNewCivilizations() {
        String[] wordsToFeed = new String[]{"Manuel", "Miguel", "Mandela"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordsToFeed, Map.class);
        ResponseEntity<Civilization> response = restTemplate.postForEntity("/civilizations", null, Civilization.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().getName().isEmpty());
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
    }

    @Test
        // @Order(4)
    void getAllCivilizations() {
        String[] wordsToFeed = new String[]{"Manuel", "Miguel", "Mandela"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordsToFeed, Map.class);
        ResponseEntity<Civilization> responseCiv1 = restTemplate.postForEntity("/civilizations", null, Civilization.class);
        ResponseEntity<Civilization> responseCiv2 = restTemplate.postForEntity("/civilizations", null, Civilization.class);
        ResponseEntity<Civilization> responseCiv3 = restTemplate.postForEntity("/civilizations", null, Civilization.class);
        ResponseEntity<Map> responseAllCivilizations = restTemplate.getForEntity("/civilizations/getAll", Map.class);
        assertEquals(HttpStatus.OK, responseCiv1.getStatusCode());
        assertEquals(HttpStatus.OK, responseCiv2.getStatusCode());
        assertEquals(HttpStatus.OK, responseCiv3.getStatusCode());
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
        assertEquals(HttpStatus.OK, responseAllCivilizations.getStatusCode());
    }

    @Test
    void learnAResource() {
        String[] wordToFeed = new String[]{"Aki", "Capo", "Del", "Mundo"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordToFeed, Map.class);
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
        ResponseEntity<Civilization> respondeCreatedCiv = restTemplate.postForEntity("/civilizations", null, Civilization.class);
        assertEquals(HttpStatus.OK, respondeCreatedCiv.getStatusCode());
        String civilizationName = respondeCreatedCiv.getBody().getName();
        ResponseEntity<String> responseResources = restTemplate.postForEntity("/civilizations/" + civilizationName + "/learnResource", 100, String.class);
        assertEquals(HttpStatus.OK, responseResources.getStatusCode());
        assertTrue(responseResources.getBody().contains("improved"));
    }

    @Test
    void discoverSomething() {
        String[] wordToFeed = new String[]{"Aki", "Capo", "Del", "Mundo"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordToFeed, Map.class);
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
        ResponseEntity<Civilization> respondeCreatedCiv = restTemplate.postForEntity("/civilizations", null, Civilization.class);
        assertEquals(HttpStatus.OK, respondeCreatedCiv.getStatusCode());
        String civilizationName = respondeCreatedCiv.getBody().getName();
        ResponseEntity<String> responseResources = restTemplate.postForEntity("/civilizations/" + civilizationName + "/learnResource", 100, String.class);
        assertEquals(HttpStatus.OK, responseResources.getStatusCode());
        assertTrue(responseResources.getBody().contains("improved"));
        ResponseEntity<String> responseDiscovery = restTemplate.postForEntity("/civilizations/" + civilizationName + "/discoverSomething", 100, String.class);
        System.out.println(responseDiscovery);
        assertEquals(HttpStatus.OK, responseDiscovery.getStatusCode());
        assertTrue(responseDiscovery.getBody().contains("discovered"));
    }

    @Test
    void ageCivilization() {
        String[] wordToFeed = new String[]{"Aki", "Capo", "Del", "Mundo"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordToFeed, Map.class);
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
        ResponseEntity<Civilization> response = restTemplate.postForEntity("/civilizations", null, Civilization.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        String nameCivliztion = response.getBody().getName();
        String years = "100";
        ResponseEntity<String> responseAging = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/ageCivilization", 100, String.class);
        assertEquals(HttpStatus.OK, responseAging.getStatusCode());
        assertTrue(responseAging.getBody().contains("have passed"));
    }

    @Test
    void createSpecialPerson() {
        String[] wordToFeed = new String[]{"Aki", "Capo", "Del", "Mundo"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordToFeed, Map.class);
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
        ResponseEntity<Civilization> response = restTemplate.postForEntity("/civilizations", null, Civilization.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        String nameCivliztion = response.getBody().getName();
        ResponseEntity<Person> responsePerso = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/createSpecialPerson", null, Person.class);
        assertEquals(HttpStatus.OK, responsePerso.getStatusCode());
    }
}