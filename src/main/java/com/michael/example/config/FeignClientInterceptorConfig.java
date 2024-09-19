package com.michael.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;

/**
 * Configuration class for the Feign client interceptor.
 *
 *
 * Adds headers to outgoing requests.
 */
public class FeignClientInterceptorConfig {
	@Value("${external.api.bank-account.auth-key}")
	private String authKey;
	@Value("${external.api.bank-account.token}")
	private String authToken;

	@Bean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate -> requestTemplate.header("Content-Type", "application/json; charset=utf-8")
			.header("HeaderToken", authToken)
			.header("Authorization", authKey)
			.header("accept", "*/*");
	}
}
