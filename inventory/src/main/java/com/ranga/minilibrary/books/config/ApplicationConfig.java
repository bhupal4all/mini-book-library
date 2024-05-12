package com.ranga.minilibrary.books.config;

import com.ranga.minilibrary.books.interceptor.CoRelationIDInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class ApplicationConfig implements WebMvcConfigurer {
    @Autowired
    private CoRelationIDInterceptor coRelationIDInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.error(">>> Adding CoRelationIDInterceptor");
        registry.addInterceptor(coRelationIDInterceptor);
    }
}
