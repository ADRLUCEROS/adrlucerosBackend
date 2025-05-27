package com.adrLuceros.transporte.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")          // Permite CORS para todas las rutas
                        .allowedOrigins("*")        // Permite todos los orígenes
                        .allowedMethods("*")        // Permite todos los métodos HTTP (GET, POST, etc)
                        .allowedHeaders("*")        // Permite todos los headers
                        .allowCredentials(false);   // Permite enviar cookies/autenticación
            }
        };
    }
}
