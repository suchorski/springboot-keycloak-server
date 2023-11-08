package com.suchorski.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.suchorski.server.keycloak.ServerProperties;
import org.jboss.resteasy.core.ResteasyDeploymentImpl;

@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
@EnableConfigurationProperties(ServerProperties.class)
public class SpringbootKeycloakServerApplication {

	public static void main(String[] args) {
            ResteasyDeploymentImpl ha;
		SpringApplication.run(SpringbootKeycloakServerApplication.class, args);
	}

}
