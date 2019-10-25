package com.gdkj.demo;

import com.gdkj.demo.config.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = {DBConfig2.class })
@SpringBootApplication
public class DemoSpringCloudAtomikosApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudAtomikosApplication.class, args);
    }

}
