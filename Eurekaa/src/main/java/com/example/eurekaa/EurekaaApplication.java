package com.example.eurekaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurekaaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaaApplication.class, args);
	}

}
