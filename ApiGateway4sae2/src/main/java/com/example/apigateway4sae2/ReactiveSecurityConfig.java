package com.example.apigateway4sae2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.List;

@Configuration
@EnableWebFluxSecurity
@EnableMethodSecurity
@EnableWebFlux
public class ReactiveSecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                // Disable CSRF
                .csrf(csrf -> csrf.disable())

                // Optionally enable CORS if needed (or configure as you like)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/error", "/auth/register", "/registerUser", "/update-password/**", "/api/auth/**", "/swagger-ui/**", "/v3/api-docs/**", "/h2/**").permitAll()
                        .pathMatchers("/api/admin/**").hasRole("ADMINISTRATEUR")
                        .pathMatchers("/api/formateur/**").hasRole("FORMATEUR")
                        .pathMatchers("/api/etudiant/**").hasRole("ETUDIANT")
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwtSpec -> jwtSpec.jwtDecoder(jwtDecoder())));

        return http.build();
    }
    @Bean
    public ReactiveJwtDecoder jwtDecoder() {
        return ReactiveJwtDecoders.fromIssuerLocation("http://localhost:8081/realms/Khotwa");
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
