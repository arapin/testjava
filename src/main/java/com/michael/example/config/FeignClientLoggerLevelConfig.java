package com.michael.example.config;

import org.springframework.context.annotation.Bean;

import feign.Logger;

/**
 * The FeignClientLoggerLevelConfig class is a configuration class used to set the logger level for Feign clients.
 */
public class FeignClientLoggerLevelConfig {
	@Bean
	Logger.Level feignClientLoggerLevel() {
		return Logger.Level.FULL;
	}
}
