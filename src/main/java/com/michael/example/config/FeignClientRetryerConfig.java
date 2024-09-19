package com.michael.example.config;

import org.springframework.context.annotation.Bean;

import feign.Retryer;

/**
 * The FeignClientRetryerConfig class is a configuration class used to define the retryer for Feign clients.
 */
public class FeignClientRetryerConfig {
	@Bean
	public Retryer feignRetryer() {
		return new Retryer.Default(100, 1000, 3);
	}
}
