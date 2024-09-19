package com.michael.example.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;

/**
 * Configuration class for Swagger.
 */
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
	@Bean
	public GroupedOpenApi getV2Api() {
		return GroupedOpenApi.builder().group("Michael Test").pathsToMatch("/example/**").build();
	}

	@Bean
	public OpenAPI gmeLoanApi() {
		Info info = new Info().title("Michael Test API").description("Michael Test API Documentation");
		return new OpenAPI().info(info);
	}
}
