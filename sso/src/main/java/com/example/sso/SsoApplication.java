package com.example.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
@EnableResourceServer
@EnableRedisHttpSession
public class SsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoApplication.class, args);
	}

	@Bean
	public KeyPair keyPair() throws NoSuchAlgorithmException {
		KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
		keygen.initialize(2048);
		return keygen.generateKeyPair();
	}
}
