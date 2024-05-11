package com.ranga.minilibrary.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }

    @Bean
    public GlobalFilter customResponseHeaderFilter() {
        return (exchange, chain) -> {
            exchange.getResponse().getHeaders().add("X-Author", "Ranga Bhupal");
            return chain.filter(exchange);
        };
    }

}
