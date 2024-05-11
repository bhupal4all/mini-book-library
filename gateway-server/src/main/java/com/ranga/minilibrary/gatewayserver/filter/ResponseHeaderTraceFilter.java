package com.ranga.minilibrary.gatewayserver.filter;

import com.ranga.minilibrary.gatewayserver.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

@Configuration
public class ResponseHeaderTraceFilter {
    private final static Logger log = LoggerFactory.getLogger(ResponseHeaderTraceFilter.class);

    @Bean
    public GlobalFilter response() {
        return ((exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {
            final HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
            final HttpHeaders responseHeaders = exchange.getResponse().getHeaders();
            if (responseHeaders.containsKey(Constants.CO_RELATION_ID)) {
                log.debug("Reading Co-Relation-ID: {}", responseHeaders.get(Constants.CO_RELATION_ID));
            } else {
                if (requestHeaders.containsKey(Constants.CO_RELATION_ID)) {
                    final String coRelationId = requestHeaders.getFirst(Constants.CO_RELATION_ID);
                    log.debug("Adding Co-Relation-ID: {}", coRelationId);
                    responseHeaders.add(Constants.CO_RELATION_ID, coRelationId);
                }
            }
        })));
    }

}
