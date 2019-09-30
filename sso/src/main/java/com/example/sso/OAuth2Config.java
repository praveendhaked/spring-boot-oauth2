package com.example.sso;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
=======
import org.springframework.context.annotation.Configuration;
>>>>>>> password_grant
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

<<<<<<< HEAD
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public TokenStore tokenStore() {
        RedisTokenStore redis = new RedisTokenStore(redisConnectionFactory);
        return redis;
=======
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
>>>>>>> password_grant
    }

    public OAuth2Config(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("foo")
                .secret(passwordEncoder.encode("bar"))
<<<<<<< HEAD
                .authorizedGrantTypes("refresh_token", "authorization_code", "client_credentials")
                .scopes("user_info")
                .redirectUris("http://localhost:8082/app1/login", "http://localhost:8083/app2/login")
                .autoApprove(true)
                .accessTokenValiditySeconds(120)
                .refreshTokenValiditySeconds(300)
                .and()
                .withClient("foo1")
                .secret(passwordEncoder.encode("bar1"))
                .authorizedGrantTypes("refresh_token", "authorization_code", "client_credentials")
                .scopes("user_info")
                .redirectUris("http://localhost:8082/app1/login", "http://localhost:8083/app2/login")
                .autoApprove(true)
                .accessTokenValiditySeconds(120)
                .refreshTokenValiditySeconds(300);
=======
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("user_info")
//                .redirectUris("http://localhost:8082/app1/login", "http://localhost:8083/app2/login")
//                .autoApprove(true)
                .and()
                .withClient("foo1")
                .secret(passwordEncoder.encode("bar1"))
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("user_info");
//                .redirectUris("http://localhost:8082/app1/login", "http://localhost:8083/app2/login")
//                .autoApprove(true);
>>>>>>> password_grant
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints){
        endpoints
                .authenticationManager(authenticationManager)
                .tokenStore(tokenStore());
    }
}