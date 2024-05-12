package com.ranga.minilibrary.books.config;

import com.ranga.minilibrary.books.interceptor.CoRelationIdInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class ApplicationConfig implements WebMvcConfigurer {
    @Autowired
    CoRelationIdInterceptor coRelationIdInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        log.error(">>> Adding CoRelationIdInterceptor");
        registry.addInterceptor(coRelationIdInterceptor);
    }
}
