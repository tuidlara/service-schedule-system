package com.arthur.sistema_agendamentos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Sistema de Agendamentos API")
                        .description("API para gerenciamento de agendamentos e tipos de serviço.")
                        .version("1.0"));
    }
}