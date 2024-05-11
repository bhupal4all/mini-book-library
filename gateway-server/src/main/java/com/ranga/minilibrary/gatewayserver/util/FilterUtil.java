package com.ranga.minilibrary.gatewayserver.util;

import org.springframework.web.server.ServerWebExchange;

public class FilterUtil {
    public static void setRequestHeader(final ServerWebExchange exchange, final String headerName, final String headerValue) {
        exchange.mutate().request(
                exchange.getRequest().mutate().header(headerName, headerValue).build()
        ).build();
    }
}
