package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019-08-21 12:00
 * @Description
 **/
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/allUser")
    public List<User> selectAllUsers() {
        return restTemplate.getForObject("http://USER-PROVIDER/userAll", List.class);
    }

    @GetMapping("/userAll")
    public List<User> selectAllUser() {
        return restTemplate.getForObject("http://USER-PROVIDER-HYSTRIX/hystrixUser", List.class);
    }

}
