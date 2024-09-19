package com.michael.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages = "com.gme.gmeloanapi.repository.finance",
	entityManagerFactoryRef = "financeEntityManagerFactory",
	transactionManagerRef = "financeTransactionManager"
)
public class FinanceDatasourceConfig {
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.finance")
	public DataSourceProperties financeDatasourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.finance.configuration") // DB와 관련된 설정값들의 접두사에 .configuration을 붙여준다.
	public DataSource financeDatasource() {
		return financeDatasourceProperties()
			.initializeDataSourceBuilder()
			.type(HikariDataSource.class)
			.build();
	}

	@Bean(name = "financeEntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean financeEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		DataSource dataSource = financeDatasource();
		return builder
			.dataSource(dataSource)
			.packages("com.gme.gmeloanapi.repository.finance.entity") // 첫번째 DB와 관련된 엔티티들이 있는 패키지(폴더) 경로
			.persistenceUnit("financeEntityManager")
			.build();
	}

	@Bean(name = "financeTransactionManager")
	@Primary
	public PlatformTransactionManager financeTransactionManager(
		final @Qualifier("financeEntityManagerFactory") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean
	) {
		return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
	}
}
