package com.michael.example.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;

/**
 * Configuration class for Swagger.
 */
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
	@Bean
	public GroupedOpenApi getTestApi() {
		return GroupedOpenApi.builder().group("Michael Test").pathsToMatch("/example/**").build();
	}

	@Bean
	public GroupedOpenApi getShoppingMallApi() {
		return GroupedOpenApi.builder().group("Shopping Mall Test").pathsToMatch("/shopping/**").build();
	}

	@Bean
	public OpenAPI gmeLoanApi() {
		Info info = new Info().title("Michael Test API").description("Michael Test API Documentation");
		return new OpenAPI().info(info).components(
			new Components().addSecuritySchemes("Authorization", new SecurityScheme().name("Authorization")
				.type(SecurityScheme.Type.HTTP)
				.in(SecurityScheme.In.HEADER)
				.scheme("bearer")
				.bearerFormat("JWT"))
		);
	}
}
