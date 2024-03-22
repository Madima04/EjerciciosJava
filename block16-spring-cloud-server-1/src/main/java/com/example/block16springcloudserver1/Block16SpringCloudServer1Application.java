package com.example.block16springcloudserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Block16SpringCloudServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(Block16SpringCloudServer1Application.class, args);
	}

}
