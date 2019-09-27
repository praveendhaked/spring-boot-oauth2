package com.example.app1;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.requestMatchers()
                .and()
                .authorizeRequests().antMatchers("/role1/**").access("hasRole('ROLE1')")
                .and()
                .authorizeRequests().antMatchers("/role2/**").access("hasRole('ROLE2')")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
