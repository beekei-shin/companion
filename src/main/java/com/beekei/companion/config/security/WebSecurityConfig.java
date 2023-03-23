package com.beekei.companion.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final String[] ALL_METHOD_WHITELIST = {
    };

    private final String[] GET_WHITELIST = {
    };

    private final String[] POST_WHITELIST = {
        "/member/*"
    };

    private final String[] PUT_WHITELIST = {
    };

    private final String[] DELETE_WHITELIST = {
    };


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()
            .and()
            .csrf().disable()
            .headers()
            .xssProtection()
            .and()
            .contentSecurityPolicy("script-src 'self'")
            .and()
            .frameOptions().disable()
            .and()
            .formLogin().disable()
            .httpBasic().disable()
            .authorizeRequests()
            .anyRequest().permitAll();
//            .antMatchers(ALL_METHOD_WHITELIST).permitAll()
//            .antMatchers(HttpMethod.GET, GET_WHITELIST).permitAll()
//            .antMatchers(HttpMethod.POST, POST_WHITELIST).permitAll()
//            .antMatchers(HttpMethod.PUT, PUT_WHITELIST).permitAll()
//            .antMatchers(HttpMethod.DELETE, DELETE_WHITELIST).permitAll()
//            .antMatchers("/app/**").hasIpAddress("localhost")
//            .anyRequest().authenticated();
    }

}
