package com.suchorski.server.keycloak;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "keycloak.server")
public record Properties(String contextPath, String username, String password) {}
