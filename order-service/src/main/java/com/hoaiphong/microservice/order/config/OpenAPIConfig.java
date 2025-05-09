package com.hoaiphong.microservice.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI orderServiceAPI() {
        return new OpenAPI()
                .info(new Info().title("Order Service API")
                        .description("Order Service API")
                        .version("1.0.0")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Order Service By Link")
                        .url("https://google.com")
                        );
    }

}
