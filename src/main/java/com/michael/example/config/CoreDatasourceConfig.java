package com.michael.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages = "com.gme.gmeloanapi.repository.core", // 첫번째 DB가 있는 패키지(폴더) 경로
	entityManagerFactoryRef = "coreEntityManagerFactory", // EntityManager의 이름
	transactionManagerRef = "coreTransactionManager" // 트랜잭션 매니저의 이름
)
public class CoreDatasourceConfig {
	@Bean
	@ConfigurationProperties("spring.datasource.core") // application.properties에 작성된 DB와 관련된 설정 값들의 접두사
	public DataSourceProperties coreDatasourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("spring.datasource.core.configuration") // DB와 관련된 설정값들의 접두사에 .configuration을 붙여준다.
	public DataSource coreDatasource() {
		return coreDatasourceProperties()
			.initializeDataSourceBuilder()
			.type(HikariDataSource.class)
			.build();
	}

	@Bean(name = "coreEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean coreEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		DataSource dataSource = coreDatasource();
		return builder
			.dataSource(dataSource)
			.packages("com.gme.gmeloanapi.repository.core.entity") // 첫번째 DB와 관련된 엔티티들이 있는 패키지(폴더) 경로
			.persistenceUnit("coreEntityManager")
			.build();
	}

	@Bean(name = "coreTransactionManager")
	public PlatformTransactionManager coreTransactionManager(
		final @Qualifier("coreEntityManagerFactory") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean
	) {
		return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
	}
}
