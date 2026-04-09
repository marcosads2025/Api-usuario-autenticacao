package com.example.LoginUsuario.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita proteção CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // Libera acesso total à URL do H2
                        .anyRequest().permitAll() // Temporário: libera TODAS as outras rotas (api/users, etc) para você testar sem dor de cabeça agora
                )
                // ESTA É A LINHA MÁGICA QUE FAZ O H2 APARECER:
                .headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}