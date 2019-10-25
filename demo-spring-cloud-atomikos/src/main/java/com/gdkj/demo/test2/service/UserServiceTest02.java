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
public class UserServiceTest02 {

    @Autowired
    private UserMapperTest02 userMapperTest02;
    @Autowired
    private UserMapperTest01 userMapperTest01;

    private UserService02 userService02;

    //分布式事务
    @Transactional()
    public int insertUserTest01AndTest02(String name, Integer age) {
        // 传统分布式事务解决方案 jta+atomikos 注册同一个全局事务中
        // 第一个数据源
        int insertUserResult01 = userMapperTest01.insert(name, age);
        // 第二个数据源
        int insertUserResult02 = userMapperTest02.insert(name, age);
        int i = 1 / 0;
        int result = insertUserResult01 + insertUserResult02;
        // test01入库 test02回滚
        return result;
    }

    //分布式事务
    @Transactional()
    public int insertUserTest01AndRemoteTest02(String name, Integer age) {
        // 传统分布式事务解决方案 jta+atomikos 注册同一个全局事务中
        // 第一个数据源
        int insertUserResult01 = userMapperTest01.insert(name, age);
        // 第二个数据源
        int insertUserResult02 = userService02.insert(name, age);
        int i = 1 / 0;
        int result = insertUserResult01 + insertUserResult02;
        // test01入库 test02回滚
        return result;
    }

}

