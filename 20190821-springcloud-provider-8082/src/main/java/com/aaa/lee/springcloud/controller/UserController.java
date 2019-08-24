package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.User;
import com.aaa.lee.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019-08-21 11:59
 * @Description
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userOne")
    public User selectById() {
        return userService.selectById(2L);
    }

    @RequestMapping("/userAll")
    public List<User> selectAllUsers() {
        return userService.selectAllUser();
    }

}
