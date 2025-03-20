package net.arhitecture.filmeflixlogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Dezactivează protecția CSRF
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())  // Permite accesul liber la toate endpoint-urile
                .formLogin(form -> form.disable())  // Dezactivează login-ul standard
                .httpBasic(httpBasic -> httpBasic.disable()); // Dezactivează autentificarea Basic

        return http.build();
    }
}
