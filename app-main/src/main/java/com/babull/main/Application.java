package com.babull.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.autoconfigure.domain.EntityScan; // ¡Importación clave!

// 1. Escanea todos los componentes (@Component, @Service, @Controller)
@SpringBootApplication(scanBasePackages = {"com.babull.infra", "com.babull.core", "com.babull.main"})
// 2. Habilita el escaneo de Repositorios JPA
@EnableJpaRepositories(basePackages = "com.babull.infra.adapter.out.persistence.springdata")
// 3. ¡CORRECCIÓN CLAVE! Habilita el escaneo de Entidades JPA (@Entity)
@EntityScan(basePackages = "com.babull.infra.adapter.out.persistence.entity")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("LOG: Aplicación de Arquitectura Hexagonal iniciada en el puerto 8080.");
    }

    // ... (Tu bean de configuración CORS) ...
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Permite peticiones POST desde cualquier puerto en localhost (incluyendo XAMPP)
                registry.addMapping("/api/v1/transferencia")
                        .allowedOrigins("http://localhost", "http://localhost:*", "*")
                        .allowedMethods("POST")
                        .allowedHeaders("*");
            }
        };
    }
}
