package com.jm.marvel.configuration;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import java.net.URI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouteConfiguration {

	@Bean
	public RouterFunction<ServerResponse> routerFunction() {
		return route(GET("/"), req -> ServerResponse.temporaryRedirect(URI.create("/swagger-ui.html")).build());
	}

}
