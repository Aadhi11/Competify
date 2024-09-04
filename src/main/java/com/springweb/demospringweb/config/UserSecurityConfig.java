package com.springweb.demospringweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;  
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig{

    

    @Autowired
    private UserDetailsService userDetailsService;

   

    
    // @Bean
    // public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
    // return http.getSharedObject(AuthenticationManagerBuilder.class)
    //         .build();
    // }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;    
    }
 
    @Bean
    @Order(1)
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       http.securityMatcher("/user/**");
        return http
                .csrf(d -> d.disable())
                .formLogin(form -> form.loginPage("/user/login").defaultSuccessUrl("/user/home").permitAll())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/**").hasAuthority("USER")
                        .anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults())
                .authenticationProvider(authProvider())
                .logout(logout -> logout.logoutUrl("/user/logout"))
                .build();
    }

    
    
    
   
}
