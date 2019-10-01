package com.example.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableResourceServer
@RestController
public class App2Application {

	@GetMapping("/home")
	public String homepage(){
		return "Welcome to app2";
	}

	@GetMapping("/role1/hello")
	public String role1(){
		return "Hello from app2 role1";
	}

	@GetMapping("/role2/hello")
	public String role2() {
		return "Hello from app2 role2";
	}

	@GetMapping("/user")
	public Principal getUser(Principal principal){
		return principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(App2Application.class, args);
	}

}
