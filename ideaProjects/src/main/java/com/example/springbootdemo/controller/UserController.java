package com.example.springbootdemo.controller;

import com.example.springbootdemo.bean.User;
import com.example.springbootdemo.service.impl.IUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*等于@controller+@ResponseBody*/
@RestController
/*解决与前端跨域访问得问题*/
@CrossOrigin
@ComponentScan({"com.example.springbootdemo.service"})
@MapperScan("com.example.springbootdemo.mapper")
public class UserController {
    @Resource
    private IUserService iUserService;
    @RequestMapping("/select")
    /*用一个对象去接*/
    public User select(@RequestBody User user){
        System.out.println(user.getUsername());
        User user1 = iUserService.select(user.getUsername());
        return user1;
    }
    @RequestMapping("/addUser")
    public User addUser(@RequestBody User user){
        iUserService.addUser(user);
        return user;
    }

}
