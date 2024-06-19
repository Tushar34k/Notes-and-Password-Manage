package com.password.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.password.demo.tokengenrator.TokenGenrator;

@SpringBootApplication
public class PasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordApplication.class, args);
		
		String token = TokenGenrator.generateToken();
        System.out.println("Generated Token: " + token);
	}

}
