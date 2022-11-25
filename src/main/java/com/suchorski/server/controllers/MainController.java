package com.suchorski.server.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@ConditionalOnProperty(prefix = "keycloak.server", name = "context-redirect", havingValue = "true")
@RestController
public class MainController {

	@Value("${keycloak.server.context-path}")
	private String contextPath;

	@GetMapping
	public RedirectView root() {
		return new RedirectView(contextPath);
	}

}
