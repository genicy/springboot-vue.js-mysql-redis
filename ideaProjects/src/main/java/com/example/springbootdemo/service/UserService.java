package com.example.springbootdemo.service;

import com.example.springbootdemo.bean.User;

public interface UserService {
    public User select(String username);
    public void addUser(User user);
}
