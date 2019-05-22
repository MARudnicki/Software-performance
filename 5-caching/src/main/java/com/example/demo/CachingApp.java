package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
@EnableCaching
public class CachingApp {

	public static void main(String[] args) {
		SpringApplication.run(CachingApp.class, args);
	}

	@GetMapping
	@Cacheable(value = "hello")
	public String hello() throws Exception{

		TimeUnit.SECONDS.sleep(5);
		System.out.println("This is from server");

		return "Super heavy in calculation response !!!";
	}
}
