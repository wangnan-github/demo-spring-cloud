package com.gdkj.demo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableApolloConfig
@SpringBootApplication
public class DemoSpringCloudApolloApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudApolloApplication.class, args);
    }

}
