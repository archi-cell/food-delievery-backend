package com.fooddelivery.api_gateway.config;

import com.fooddelivery.api_gateway.filter.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("menu-service", r -> r.path("/menu/**")
                .filters(f -> f.filter(jwtAuthFilter)) // Protect with JWT
                .uri("lb://menu-service"))
            .route("order-service", r -> r.path("/orders/**")
                .filters(f -> f.filter(jwtAuthFilter))
                .uri("lb://order-service"))
            .route("auth-service", r -> r.path("/auth/**")
                .uri("lb://auth-service")) // Login/signup public
            .build();
    }
}
