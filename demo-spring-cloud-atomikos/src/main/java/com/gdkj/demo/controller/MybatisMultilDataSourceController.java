package com.gdkj.demo.controller;

import com.gdkj.demo.test2.service.UserServiceTest02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisMultilDataSourceController {

    @Autowired
    private UserServiceTest02 userServiceTest02;

    @RequestMapping("/insertUserTest2")
    public Integer insertUserTest2(String name, Integer age) {
        return userServiceTest02.insertUserTest01AndTest02(name, age);
    }

    @RequestMapping("/insertUserTest3")
    public Integer insertUserTest3(String name, Integer age) {
        return userServiceTest02.insertUserTest01AndRemoteTest02(name, age);
    }
}
