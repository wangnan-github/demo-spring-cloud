package com.gdkj.demo;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "DEMO-SPRING-CLOUD-DEPT", fallbackFactory = UserService02FallbackFactory.class)
public interface UserService02 {

    int insert(String name, Integer age);
}
