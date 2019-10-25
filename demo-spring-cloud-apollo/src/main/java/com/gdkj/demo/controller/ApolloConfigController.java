package com.gdkj.demo.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApolloConfigController {

    @ApolloConfig
    private Config config;

    @Value("${redis_con}")
    private String name;

    @Value("${mysql}")
    private String mysql;

    @RequestMapping("/apollo")
    public String getConfig(){
        return mysql;
    }

}

