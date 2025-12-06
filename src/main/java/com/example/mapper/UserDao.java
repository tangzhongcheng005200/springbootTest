package com.example.mapper;

import com.domain.TabUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from tab_user where userId = #{userId}")
    TabUser selectUser(int userId);

    @Select("select * from tab_user ")
    List<TabUser> userPage();

    @Insert("insert into tab_user(userId,userName,address)values(#{userId},#{userName},#{address})")
    void insertUser(TabUser user);
}
