package com.example.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableResourceServer
@RestController
public class App1Application {

	@GetMapping("/home")
	public String homepage(){
		return "Welcome to app1";
	}

	@GetMapping("/user")
	public Principal getUser(Principal principal){
		return principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(App1Application.class, args);
	}

}
