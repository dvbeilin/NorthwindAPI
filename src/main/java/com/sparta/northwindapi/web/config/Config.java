package com.sparta.northwindapi.web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@EnableWebMvc
@EnableWebSecurity
@Configuration
public class Config {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/orderList/*").hasRole("ADMIN")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied")
                .and()
                .formLogin()
                .and()
                .logout().permitAll();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager configureAuth() {
        List<UserDetails> users = new ArrayList<>();

        List<SimpleGrantedAuthority> adminRoles = new ArrayList<>();
        adminRoles.add(new SimpleGrantedAuthority("ADMIN"));

        UserDetails user = new User("Andrei","password",adminRoles);
        users.add(user);
        return new InMemoryUserDetailsManager(users);
    }

}
