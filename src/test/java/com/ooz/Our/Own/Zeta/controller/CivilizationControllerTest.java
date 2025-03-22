package com.ooz.Our.Own.Zeta.controller;

import com.ooz.Our.Own.Zeta.model.Civilization;
import com.ooz.Our.Own.Zeta.model.Person;
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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CivilizationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void gettingCivilizationThatDoesNotExist() {
        // Llamada a la API con un nombre que no existe
        ResponseEntity<String> response = restTemplate.getForEntity("/civilizations/Aztecs", String.class);

        // Verificar que la respuesta sea un error 500
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

        // Opcional: Verificar que el cuerpo de la respuesta contenga un mensaje de error
        assertTrue(response.getBody().contains("Civilization not found"));
    }

    @Test
    @Order(2)
    void createNewCivilizations() {
        String[] wordsToFeed = new String[]{"Manuel", "Miguel", "Mandela"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordsToFeed, Map.class);
        ResponseEntity<CivilizationDto> response = restTemplate.postForEntity("/civilizations", null, CivilizationDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
    }

    @Test
    @Order(3)
    void getAllCivilizations() {
        String[] wordsToFeed = new String[]{"Manuel", "Miguel", "Mandela"};
        ResponseEntity<Map> responseFeed = restTemplate.postForEntity("/civilizations/feedingLanguagePatterns", wordsToFeed, Map.class);
        ResponseEntity<CivilizationDto> responseCiv1 = restTemplate.postForEntity("/civilizations", null, CivilizationDto.class);
        ResponseEntity<CivilizationDto> responseCiv2 = restTemplate.postForEntity("/civilizations", null, CivilizationDto.class);
        ResponseEntity<CivilizationDto> responseCiv3 = restTemplate.postForEntity("/civilizations", null, CivilizationDto.class);
        ResponseEntity<Map> responseAllCivilizations = restTemplate.getForEntity("/civilizations/getAll", Map.class);
        assertEquals(HttpStatus.OK, responseCiv1.getStatusCode());
        assertEquals(HttpStatus.OK, responseCiv2.getStatusCode());
        assertEquals(HttpStatus.OK, responseCiv3.getStatusCode());
        assertEquals(HttpStatus.OK, responseFeed.getStatusCode());
        assertEquals(HttpStatus.OK, responseAllCivilizations.getStatusCode());
    }
}