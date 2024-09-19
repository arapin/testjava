package com.michael.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Configuration class for QueryDsl.
 */
@Configuration
public class QueryDslConfig {
	@PersistenceContext(unitName = "primaryEntityManager")
	private EntityManager primaryEntityManager;

	@Primary
	@Bean
	@Qualifier("primaryQueryFactory")
	public JPAQueryFactory financeQueryFactory() {
		return new JPAQueryFactory(primaryEntityManager);
	}
}
