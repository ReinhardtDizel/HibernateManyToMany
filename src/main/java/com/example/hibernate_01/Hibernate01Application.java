package com.example.hibernate_01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Hibernate01Application {

    public static void main(String[] args) {
        SpringApplication.run(Hibernate01Application.class, args);
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/books").allowedOrigins("http://localhost:8080");
                registry.addMapping("/books").allowedOrigins("http://localhost:3000");
                registry.addMapping("/authors").allowedOrigins("http://localhost:8080");
                registry.addMapping("/authors").allowedOrigins("http://localhost:3000");
                registry.addMapping("/*/*").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT");
                registry.addMapping("/**");

            }
        };
    }
}
