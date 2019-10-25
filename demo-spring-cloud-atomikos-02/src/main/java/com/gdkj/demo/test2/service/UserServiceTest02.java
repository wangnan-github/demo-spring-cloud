package com.gdkj.demo.test2.service;

import com.gdkj.demo.UserService02;
import com.gdkj.demo.test1.mapper.UserMapperTest01;
import com.gdkj.demo.test2.mapper.UserMapperTest02;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserServiceTest02 implements UserService02 {

    @Autowired
    private UserMapperTest02 userMapperTest02;

    //分布式事务
    @Transactional()
    public int insert(String name, Integer age) {

        int insertUserResult02 = userMapperTest02.insert(name, age);

        return insertUserResult02;
    }

}

