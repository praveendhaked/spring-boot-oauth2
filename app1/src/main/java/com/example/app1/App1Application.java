package com.example.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@SpringBootApplication
@RestController
public class App1Application {

	@GetMapping("/")
	public String homepage(){
		return "Welcome to app1";
	}

	@GetMapping("/role1/hello")
	public String role1(){
		return "Hello from app1 role1";
	}

	@GetMapping("/role2/hello")
	public String role2(){
		return "Hello from app1 role2";
	}

	public static void main(String[] args) {
		SpringApplication.run(App1Application.class, args);
	}

}
