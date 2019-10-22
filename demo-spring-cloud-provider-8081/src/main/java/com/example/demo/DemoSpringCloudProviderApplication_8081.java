package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DemoSpringCloudProviderApplication_8081 {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudProviderApplication_8081.class, args);
    }

}
