package com.example.pack.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
        private SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
                return httpSecurity
                        .formLogin(httpForm -> {
                                httpForm.loginPage("/req/login").permitAll();
                                httpForm.defaultSuccessUrl("/index");
                                
                        })

                        .authorizeHttpRequests(registry -> {
                                registry.requestMatchers("/req/**", "/css/**", "/js/**").permitAll();
                                registry.anyRequest().authenticated();
                        })

                        .build();
        }
}
