package com.example.block16SpringCloudTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Block16SpringCloudTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block16SpringCloudTicketApplication.class, args);
	}

}
