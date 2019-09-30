package com.example.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class App1Application {

	@GetMapping("/")
	public String homepage(){
		return "Welcome to app1";
	}

	public static void main(String[] args) {
		SpringApplication.run(App1Application.class, args);
	}

}
