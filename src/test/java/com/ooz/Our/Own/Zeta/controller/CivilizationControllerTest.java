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
import java.util.*;

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
        assertTrue(responseResources.getBody().contains("discovered"));
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
        assertTrue(responseResources.getBody().contains("discovered") || responseResources.getBody().contains("improved"));
        ResponseEntity<String> responseDiscovery = restTemplate.postForEntity("/civilizations/" + civilizationName + "/discoverSomething", 100, String.class);
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
        ResponseEntity<String> responsePerso = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/createSpecialPerson", null, String.class);
        assertEquals(HttpStatus.OK, responsePerso.getStatusCode());
        assertTrue(responsePerso.getBody().contains("was born!"));
    }

    @Test
    void getHistoryLog() {
        String[] wordToFeed = new String[]{"Aki", "Capo", "Del", "Mundo"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordToFeed, Map.class);
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
        ResponseEntity<Civilization> response = restTemplate.postForEntity("/civilizations", null, Civilization.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        String nameCivliztion = response.getBody().getName();
        ResponseEntity<String> responsePerso = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/createSpecialPerson", null, String.class);
        assertEquals(HttpStatus.OK, responsePerso.getStatusCode());
        assertTrue(responsePerso.getBody().contains("was born!"));
        ResponseEntity<String> responseResources = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/learnResource", 100, String.class);
        assertEquals(HttpStatus.OK, responseResources.getStatusCode());
        assertTrue(responseResources.getBody().contains("discovered"));
        ResponseEntity<String> responseDiscovery = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/discoverSomething", 100, String.class);
        assertEquals(HttpStatus.OK, responseDiscovery.getStatusCode());
        assertTrue(responseDiscovery.getBody().contains("discovered"));
        ResponseEntity<List> responseHistoryLog = restTemplate.getForEntity("/civilizations/" + nameCivliztion + "/getHistoryLog", List.class);
        assertEquals(HttpStatus.OK, responseHistoryLog.getStatusCode());
        assertFalse(responseHistoryLog.getBody().isEmpty());
    }

    @Test
    void getCivilizationValue() {
        String[] wordToFeed = new String[]{"Aki", "Capo", "Del", "Mundo"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordToFeed, Map.class);
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
        ResponseEntity<Civilization> response = restTemplate.postForEntity("/civilizations", null, Civilization.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        String nameCivliztion = response.getBody().getName();
        ResponseEntity<Integer> responseValue = restTemplate.getForEntity("/civilizations/" + nameCivliztion + "/getValue", Integer.class);
        assertTrue(responseValue.getBody().intValue() > 0);
        assertEquals(HttpStatus.OK, responseValue.getStatusCode());
    }

    @Test
    void getCivilizationResources() {
        String[] wordToFeed = new String[]{"Aki", "Capo", "Del", "Mundo"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordToFeed, Map.class);
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
        ResponseEntity<Civilization> responseCiv = restTemplate.postForEntity("/civilizations", null, Civilization.class);
        assertEquals(HttpStatus.OK, responseCiv.getStatusCode());
        String nameCivliztion = responseCiv.getBody().getName();
        ResponseEntity<String> responsePostResources = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/learnResource", 100, String.class);
        assertEquals(HttpStatus.OK, responsePostResources.getStatusCode());
        assertTrue(responsePostResources.getBody().contains("discovered"));
        ResponseEntity<Map> responseGetResources = restTemplate.getForEntity("/civilizations/" + nameCivliztion + "/getResources", Map.class);
        assertFalse(responseGetResources.getBody().isEmpty());
        assertEquals(HttpStatus.OK, responseGetResources.getStatusCode());
    }

    @Test
    void getCivilizationDiscoveries() {
        String[] wordToFeed = new String[]{"Aki", "Capo", "Del", "Mundo"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordToFeed, Map.class);
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
        ResponseEntity<Civilization> responseCiv = restTemplate.postForEntity("/civilizations", null, Civilization.class);
        assertEquals(HttpStatus.OK, responseCiv.getStatusCode());
        String nameCivliztion = responseCiv.getBody().getName();
        ResponseEntity<String> responsePostResources = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/learnResource", 100, String.class);
        assertEquals(HttpStatus.OK, responsePostResources.getStatusCode());
        assertTrue(responsePostResources.getBody().contains("Civilization"));
        ResponseEntity<String> responsePOSTdiscoveries = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/discoverSomething", 100, String.class);
        assertEquals(HttpStatus.OK, responsePOSTdiscoveries.getStatusCode());
        assertTrue(responsePOSTdiscoveries.getBody().contains("Civilization"));
        ResponseEntity<String> responsePOSTdiscoveries2 = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/discoverSomething", 100, String.class);
        assertEquals(HttpStatus.OK, responsePOSTdiscoveries2.getStatusCode());
        assertTrue(responsePOSTdiscoveries2.getBody().contains("Civilization"));
        ResponseEntity<String> responsePOSTdiscoveries3 = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/discoverSomething", 100, String.class);
        assertEquals(HttpStatus.OK, responsePOSTdiscoveries3.getStatusCode());
        assertTrue(responsePOSTdiscoveries3.getBody().contains("Civilization"));
        ResponseEntity<String> responsePOSTdiscoveries4 = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/discoverSomething", 100, String.class);
        assertEquals(HttpStatus.OK, responsePOSTdiscoveries4.getStatusCode());
        assertTrue(responsePOSTdiscoveries4.getBody().contains("Civilization"));
        ResponseEntity<String> responsePOSTdiscoveries5 = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/discoverSomething", 100, String.class);
        assertEquals(HttpStatus.OK, responsePOSTdiscoveries5.getStatusCode());
        assertTrue(responsePOSTdiscoveries5.getBody().contains("Civilization"));
        ResponseEntity<String> responsePOSTdiscoveries6 = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/discoverSomething", 100, String.class);
        assertEquals(HttpStatus.OK, responsePOSTdiscoveries6.getStatusCode());
        assertTrue(responsePOSTdiscoveries6.getBody().contains("Civilization"));
        ResponseEntity<String> responsePOSTdiscoveries7 = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/discoverSomething", 100, String.class);
        assertEquals(HttpStatus.OK, responsePOSTdiscoveries7.getStatusCode());
        assertTrue(responsePOSTdiscoveries7.getBody().contains("Civilization"));
        ResponseEntity<String> responsePOSTdiscoveries8 = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/discoverSomething", 100, String.class);
        assertEquals(HttpStatus.OK, responsePOSTdiscoveries8.getStatusCode());
        assertTrue(responsePOSTdiscoveries8.getBody().contains("Civilization"));
        ResponseEntity<String> responsePOSTdiscoveries9 = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/discoverSomething", 100, String.class);
        assertEquals(HttpStatus.OK, responsePOSTdiscoveries9.getStatusCode());
        assertTrue(responsePOSTdiscoveries9.getBody().contains("Civilization"));
        ResponseEntity<String> responsePOSTdiscoveries10 = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/discoverSomething", 100, String.class);
        assertEquals(HttpStatus.OK, responsePOSTdiscoveries10.getStatusCode());
        assertTrue(responsePOSTdiscoveries10.getBody().contains("Civilization"));
        ResponseEntity<Map> responseGETDiscoveries = restTemplate.getForEntity("/civilizations/" + nameCivliztion + "/getDiscoveries", Map.class);
    }

    @Test
    void getImportantPeopleFromAPI() {
        String[] wordToFeed = new String[]{"Aki", "Capo", "Del", "Mundo"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordToFeed, Map.class);
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
        ResponseEntity<Civilization> response = restTemplate.postForEntity("/civilizations", null, Civilization.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        String nameCivliztion = response.getBody().getName();
        ResponseEntity<String> responsePerso = restTemplate.postForEntity("/civilizations/" + nameCivliztion + "/createSpecialPerson", null, String.class);
        assertEquals(HttpStatus.OK, responsePerso.getStatusCode());
        assertTrue(responsePerso.getBody().contains("was born!"));
        ResponseEntity<Map> responsePeople = restTemplate.getForEntity("/civilizations/" + nameCivliztion + "/getImportantIndividuals", Map.class);
        System.out.println(responsePeople.getBody());
        assertEquals(HttpStatus.OK, responsePeople.getStatusCode());
        assertFalse(responsePeople.getBody().isEmpty());
    }

}