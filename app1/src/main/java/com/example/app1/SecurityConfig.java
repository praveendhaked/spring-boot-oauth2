package com.example.app1;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class SecurityConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/actuator/**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/role1/**").access("hasRole('ROLE1')")
                .and()
                .authorizeRequests().antMatchers("/role2/**").access("hasRole('ROLE2')")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}