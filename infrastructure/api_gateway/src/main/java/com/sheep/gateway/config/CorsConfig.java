package com.sheep.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * 解决跨域请求问题
 */
@Configuration
public class CorsConfig {

    @Autowired
    private CorsWebFilter corsWebFilter;

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许任意请求方式访问
        corsConfiguration.addAllowedMethod("*");
        //允许任意地址
        corsConfiguration.addAllowedOrigin("*");
        //允许任意请求头
        corsConfiguration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(source);
    }
}
