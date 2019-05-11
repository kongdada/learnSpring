package com.water.kaka.mapper;

import com.water.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    List<User> findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(ID, NAME, AGE) VALUES(#{id}, #{name}, #{age})")
    int insert(@Param("id") Integer id, @Param("name") String name, @Param("age") Integer age);

    @Select("SELECT * FROM USER ")
    List<User> findUserList();
}
