package com.aaa.lee.springcloud.api;

import com.aaa.lee.springcloud.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/8/24 9:51
 * @Description
 *  如果需要使用feign，就必须存在一个service接口(一定是service层，不能是其他层，因为只有service才会控制事务，feign的使用最大特点就是AOP)
 *  所有的Service接口中，都必须把抽象方法标注上@RequestMapping("")-->里面的值必须要和生产者项目中的controller的requestMapping向对相应
 *  在IUserService类上添加@FeignClient注解，把整个接口标识为feign的客户端
 *  @FeignClient(value = "")--->value值指向的就是生产者的application.name值
 **/
@FeignClient(value = "user-provider", fallbackFactory = com.aaa.lee.springcloud.api.UserFallBackFactory.class)
public interface IUserService {

    @RequestMapping("/userAll")
    List<User> selectAllUsers();

    @RequestMapping("/userOne")
    User selectOne();

}
