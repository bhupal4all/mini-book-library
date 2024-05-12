package com.ranga.minilibrary.books.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class CoRelationIdInterceptor implements HandlerInterceptor {
    private final String CO_RELATION_ID = "Co-Relation-ID";

    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final Object handler) throws Exception {
        log.info("[ENTRY] URI: {} , Correlation ID: {}", request.getRequestURI(), request.getHeader(CO_RELATION_ID));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(final HttpServletRequest request,
                           final HttpServletResponse response,
                           final Object handler,
                           final ModelAndView modelAndView) throws Exception {
        log.info("[EXIT] URI: {} , Correlation ID: {}", request.getRequestURI(), request.getHeader(CO_RELATION_ID));
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(final HttpServletRequest request,
                                final HttpServletResponse response,
                                final Object handler,
                                final Exception ex) throws Exception {
        log.info("[AFTER COMPLETION] URI: {} , Correlation ID: {}", request.getRequestURI(), request.getHeader(CO_RELATION_ID));
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
