package com.ooz.Our.Own.Zeta.controller;

import com.ooz.Our.Own.Zeta.model.Civilization;
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
}