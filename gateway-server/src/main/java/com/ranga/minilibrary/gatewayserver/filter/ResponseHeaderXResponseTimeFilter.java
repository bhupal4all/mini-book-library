package com.ranga.minilibrary.gatewayserver.filter;

import com.ranga.minilibrary.gatewayserver.Constants;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class ResponseHeaderXResponseTimeFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(final ServerWebExchange exchange, final GatewayFilterChain chain) {
        final long startTime = System.currentTimeMillis();
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            exchange.getResponse().getHeaders().add(Constants.X_RESPONSE_TIME, System.currentTimeMillis() - startTime + "ms");
        }));
    }
}
