package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.bean.User;
import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@ComponentScan({"com.example.springbootdemo.mapper"})
@Service("userService")
public class IUserService implements UserService {
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    private UserMapper userMapper;
    @Cacheable(value = "user", key = "#root.targetClass + #username", unless = "#result eq null")
    @Override
    public User select(String username) {
        System.out.println("无法从缓存中查询,将从数据库中查询");
        return userMapper.select(username);
    }
    @CachePut(value="user1",key = "#root.targetClass + #user.username")
    @Override
    public void addUser(User user) {
        userMapper.insertUser(user) ;
    }


}
