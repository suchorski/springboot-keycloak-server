package com.suchorski.server.keycloak.providers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import jakarta.servlet.ServletContext;

import org.keycloak.common.util.Resteasy;
import org.keycloak.common.util.SystemEnvProperties;
import org.keycloak.services.util.JsonConfigProviderFactory;
import org.keycloak.util.JsonSerialization;

public class JsonProviderFactory extends JsonConfigProviderFactory {

	public static final String SERVER_CONTEXT_CONFIG_PROPERTY_OVERRIDES = "keycloak.server.context.config.property-overrides";

	@Override
	protected Properties getProperties() {
		return new SystemEnvProperties(getPropertyOverrides());
	}

	private Map<String, String> getPropertyOverrides() {
		final var context = Resteasy.getContextData(ServletContext.class);
		final var propertyOverridesMap = new HashMap<String, String>();
		final var propertyOverrides = context.getInitParameter(SERVER_CONTEXT_CONFIG_PROPERTY_OVERRIDES);
		try {
			if (context.getInitParameter(SERVER_CONTEXT_CONFIG_PROPERTY_OVERRIDES) != null) {
				final var jsonObj = JsonSerialization.mapper.readTree(propertyOverrides);
				jsonObj.fields().forEachRemaining(e -> propertyOverridesMap.put(e.getKey(), e.getValue().asText()));
			}
		} catch (IOException e) {
		}
		return propertyOverridesMap;
	}

}
