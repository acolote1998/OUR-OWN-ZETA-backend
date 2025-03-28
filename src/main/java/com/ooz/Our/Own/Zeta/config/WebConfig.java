package com.ooz.Our.Own.Zeta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir solicitudes CORS para todas las rutas
        registry.addMapping("/**") // Aplica a todas las rutas
                .allowedOrigins("http://localhost:5173") // Permite solicitudes desde el frontend en http://localhost:5173
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("*"); // Permite todos los headers
    }
}