package com.gdkj.demo.test1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapperTest01 {

    @Insert("INSERT INTO `user`(`name`,`age`) VALUE(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") int age);

}
