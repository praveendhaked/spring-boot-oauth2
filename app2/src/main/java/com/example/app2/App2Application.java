package com.example.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App2Application {

	@GetMapping("/")
	public String homepage(){
		return "Welcome to app2";
	}

	@GetMapping("/role1/hello")
	public String role1(){
		return "Hello from app2 role1";
	}

	@GetMapping("/role2/hello")
	public String role2(){
		return "Hello from app2 role2";
	}

	public static void main(String[] args) {
		SpringApplication.run(App2Application.class, args);
	}

}
