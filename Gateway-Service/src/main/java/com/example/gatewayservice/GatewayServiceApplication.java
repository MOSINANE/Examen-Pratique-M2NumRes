package com.example.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				// Route avec Circuit Breaker pour patient-service
				.route("patient-service", r -> r.path("/patients/**")
						.filters(f -> f
								.circuitBreaker(c -> c
										.setName("patientCircuitBreaker")
										.setFallbackUri("forward:/fallback/patients")))
						.uri("lb://patient-service"))

				// Route avec Circuit Breaker pour praticien-service
				.route("praticien-service", r -> r.path("/praticiens/**")
						.filters(f -> f
								.circuitBreaker(c -> c
										.setName("praticienCircuitBreaker")
										.setFallbackUri("forward:/fallback/praticiens")))
						.uri("lb://praticien-service"))
				.build();
	}
}
