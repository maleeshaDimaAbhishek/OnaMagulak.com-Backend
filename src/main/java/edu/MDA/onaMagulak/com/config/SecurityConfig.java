package edu.MDA.onaMagulak.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Disable CSRF (Cross-Site Request Forgery)
                // This is generally required to allow POST requests from tools like Postman
                .csrf(AbstractHttpConfigurer::disable)

                // 2. Configure which paths are open and which are locked
                .authorizeHttpRequests(auth -> auth
                        // ALLOW access to your user creation endpoint
                        // Change "/users/**" to match whatever your Controller's @RequestMapping is
                        .requestMatchers("/**").permitAll()

                        // LOCK everything else
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}