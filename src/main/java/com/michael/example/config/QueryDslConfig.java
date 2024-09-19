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
	@PersistenceContext(unitName = "financeEntityManager")
	private EntityManager financeEntityManager;

	@PersistenceContext(unitName = "coreEntityManager")
	private EntityManager coreEntityManager;

	@Primary
	@Bean
	@Qualifier("financeQueryFactory")
	public JPAQueryFactory financeQueryFactory() {
		return new JPAQueryFactory(financeEntityManager);
	}

	@Bean
	@Qualifier("coreQueryFactory")
	public JPAQueryFactory coreJpaQueryFactory() {
		return new JPAQueryFactory(coreEntityManager);
	}
}
