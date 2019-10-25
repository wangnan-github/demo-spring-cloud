package com.gdkj.demo;

import com.gdkj.demo.config.DBConfig1;
import com.gdkj.demo.config.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
@SpringBootApplication
public class DemoSpringCloudAtomikosApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudAtomikosApplication.class, args);
    }

}
