package com.d2d.retailbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RetailbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailbankApplication.class, args);
	}

}
