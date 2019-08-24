package com.aaa.lee.springcloud.api;

import com.aaa.lee.springcloud.model.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/8/24 14:43
 * @Description
 *      当消费者的controller调用IUserService接口的某一个方法的时候抛出异常-->直接到UserFallBackFactory类中取寻找备用方法
 *      根据工厂模式，批量进行处理，不再单个方法进行处理
 *
 **/
@Component
public class UserFallBackFactory implements FallbackFactory<IUserService> {

    public IUserService create(Throwable throwable) {
        return new IUserService() {
            public List<User> selectAllUsers() {
                List<User> userList = new ArrayList<User>();
                User user = new User();
                user.setId(1000L);
                user.setUsername("暂时无法降级，无法访问，请稍后重试！");
                user.setPassword("123456");
                user.setSalt("测试！！");
                userList.add(user);
                return userList;
            }

            public User selectOne() {
                User user = new User();
                return user;
            }
        };
    }
}
