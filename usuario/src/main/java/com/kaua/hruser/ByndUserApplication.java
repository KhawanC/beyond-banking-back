package com.kaua.hruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ByndUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ByndUserApplication.class, args);

    }

}
