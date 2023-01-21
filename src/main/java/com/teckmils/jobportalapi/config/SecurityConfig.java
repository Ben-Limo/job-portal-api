package com.teckmils.jobportalapi.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/applications", "/jobSeekerDetails", "/rating", "/recruiter")
                .authenticated()
                .requestMatchers("/jobs").permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();

        return http.build();
    }
}
