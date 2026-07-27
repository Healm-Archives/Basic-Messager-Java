package com.example.pack.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
        
        // @Bean
        // private AuthenticationProvider authenticationProvider(){
        //         DaoAuthenticationProvider provider = new DaoAuthenticationProvider(null);
        //         provider.setUserDetailsPasswordService(null);
        //         return provider;
        // }

        // @Bean
        // private PasswordEncoder passwordEncoder(){
        //         return new BCryptPasswordEncoder();
        // }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
                return httpSecurity
                        .csrf(csrf -> csrf.disable())

                        .cors(Customizer.withDefaults())

                        // .formLogin(httpForm -> {
                        //         httpForm.loginPage("/req/login").permitAll();
                        //         httpForm.defaultSuccessUrl("/");
                                
                        // })

                        .authorizeHttpRequests(registry -> {
                                // registry.requestMatchers("/api/v1/**", "/req/**", "/css/**", "/js/**")
                                registry.requestMatchers("/api/v1/**")
                                        .permitAll()
                                        .anyRequest()
                                        .authenticated();
                        })

                        .build();
        }

        @Bean
        public CorsConfigurationSource corsConfigurationSource() {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(List.of("http://localhost:3000"));
                config.setAllowedMethods(List.of("GET", "POST", "DELETE", "PUT"));
                config.setAllowedHeaders(List.of("*"));
                config.setAllowCredentials(true);

                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", config);
                return source;
        }

}
