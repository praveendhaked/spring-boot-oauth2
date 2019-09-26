package com.example.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    private PasswordEncoder passwordEncoder;

    public OAuth2Config(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("foo")
                .secret(passwordEncoder.encode("bar"))
                .authorizedGrantTypes("refresh_token", "authorization_code", "client_credentials")
                .scopes("user_info")
                .redirectUris("http://localhost:8082/app1/login", "http://localhost:8083/app2/login")
//                .accessTokenValiditySeconds(300)
                .autoApprove(true)
                .and()
                .withClient("foo1")
                .secret(passwordEncoder.encode("bar1"))
                .authorizedGrantTypes("refresh_token", "authorization_code", "client_credentials")
                .scopes("user_info")
                .redirectUris("http://localhost:8082/app1/login", "http://localhost:8083/app2/login")
//                .accessTokenValiditySeconds(300)
                .autoApprove(true);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }
}