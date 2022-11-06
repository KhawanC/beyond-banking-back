package com.kaua.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ByndEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ByndEurekaServerApplication.class, args);
	}

}
