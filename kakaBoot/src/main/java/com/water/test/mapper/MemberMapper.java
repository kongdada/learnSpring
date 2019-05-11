package com.water.test.mapper;

import com.water.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberMapper {

    @Insert("INSERT INTO USER(ID, NAME, AGE) VALUES(#{id}, #{name}, #{age})")
    int insert(@Param("id") Integer id, @Param("name") String name, @Param("age") Integer age);

    @Select("SELECT * FROM USER ")
    List<User> findMemberList();
}
