package com.ranga.minilibrary.gatewayserver.filter;

import com.ranga.minilibrary.gatewayserver.Constants;
import com.ranga.minilibrary.gatewayserver.util.FilterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Order(1)
@Component
public class RequestHeaderTraceFilter implements GlobalFilter {
    private final static Logger log = LoggerFactory.getLogger(ResponseHeaderTraceFilter.class);

    @Override
    public Mono<Void> filter(final ServerWebExchange exchange, final GatewayFilterChain chain) {

        if (exchange.getRequest().getHeaders().containsKey(Constants.CO_RELATION_ID)) {
            log.info("Reading Co-Relation-ID: {}", exchange.getRequest().getHeaders().get(Constants.CO_RELATION_ID));
        } else {
            final String traceId = UUID.randomUUID().toString();
            log.info("Adding Co-Relation-ID: {}", traceId);
            FilterUtil.setRequestHeader(exchange, Constants.CO_RELATION_ID, traceId);
        }

        return chain.filter(exchange);
    }

}
