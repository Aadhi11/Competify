package com.springweb.demospringweb.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AdminSecurityConfig {

    @Bean
    @Order(2)
    SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception{
        return http   
                .csrf(d -> d.disable())
                //.formLogin(form -> form.loginPage("/admin/login").defaultSuccessUrl("/admin/home").permitAll())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/admin/**").hasAuthority("ADMIN")
                                                    .anyRequest().permitAll()) 
                .oauth2Login(Customizer.withDefaults())                                                               
                .build();
    }
}
