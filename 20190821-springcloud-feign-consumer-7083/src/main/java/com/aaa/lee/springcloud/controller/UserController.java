package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.api.IUserService;
import com.aaa.lee.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/8/24 9:53
 * @Description
 **/
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/userAll")
    public List<User> selectAllUsers() {
        return userService.selectAllUsers();
    }

    @RequestMapping("/userOne")
    public User selectOne() {
        return userService.selectOne();
    }

}
