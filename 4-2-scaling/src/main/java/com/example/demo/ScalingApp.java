package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@RestController
public class ScalingApp {

	private static final int SERVER_CODE = Math.abs(new Random().nextInt());

	public static void main(String[] args) {
		SpringApplication.run(ScalingApp.class, args);
	}

	@GetMapping("**")
	public String hello(){
		System.out.println("Hello called");
		return "Response from servicer "+SERVER_CODE;
	}
}
