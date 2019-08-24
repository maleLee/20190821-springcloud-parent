package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.User;
import com.aaa.lee.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/8/24 14:21
 * @Description
 *      @HystrixCommand(fallbackMethod=""):
 *          当selectAllUsers()抛出异常的时候，直接执行回调方法，最终把回调方法的数据返回给服务消费方
 *          fallbackMethod = "方法名"--->一定要和自己定义的调回方法的方法名保持一致
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hystrixUser")
    @HystrixCommand(fallbackMethod="fallbackUsers")
    public List<User> selectAllUsers() throws Exception {
        List<User> userList = userService.selectAllUser();
        throw new Exception("故意抛出异常");
    }

    /**
     * @author Seven Lee
     * @description
     *      当selectAllUsers()方法抛出异常后，所要调用的方法
     * @param []
     * @date 2019/8/24
     * @return java.util.List<com.aaa.lee.springcloud.model.User>
     * @throws 
    **/
    public List<User> fallbackUsers() {
        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setId(1000L);
        user.setUsername("测试回调方法是否成功");
        user.setPassword("123456");
        user.setSalt("测试！！");
        userList.add(user);
        return userList;
    }

}
