package com.administrative.debt.infrastructure.configuration.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerApiConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .components(new Components())
        .info(getInfo());
  }

  private static Info getInfo() {
    return new Info()
        .title("Debt ApiRest Documentation")
        .description("Rest services description")
        .version("1.0");
  }

}
