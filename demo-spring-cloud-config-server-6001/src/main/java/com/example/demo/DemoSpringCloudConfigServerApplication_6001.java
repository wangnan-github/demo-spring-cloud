package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class DemoSpringCloudConfigServerApplication_6001 {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudConfigServerApplication_6001.class, args);
    }

}
