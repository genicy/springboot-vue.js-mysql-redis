package com.example.springbootdemo.mapper;

import com.example.springbootdemo.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User select(String username);

    public void insertUser(User user);
}
