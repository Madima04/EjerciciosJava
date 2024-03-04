package com.example.BlockAsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAsync
@SpringBootApplication
@EnableWebMvc
public class BlockAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockAsyncApplication.class, args);
	}
}
