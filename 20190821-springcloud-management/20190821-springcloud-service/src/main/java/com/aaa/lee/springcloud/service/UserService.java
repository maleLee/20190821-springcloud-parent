package com.aaa.lee.springcloud.service;

import com.aaa.lee.springcloud.mapper.UserMapper;
import com.aaa.lee.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019-08-21 11:58
 * @Description
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectAllUser() {
        return userMapper.selectAll();
    }

    public User selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
