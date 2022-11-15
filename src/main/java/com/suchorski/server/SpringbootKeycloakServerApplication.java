package com.suchorski.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.suchorski.server.keycloak.Properties;

@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
@EnableConfigurationProperties(Properties.class)
public class SpringbootKeycloakServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKeycloakServerApplication.class, args);
	}

}
