package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/8/23 10:51
 * @Description
 **/
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private static final String APPLICATION_NAME="http://USER-PROVIDER";

    @RequestMapping("/userAll")
    public List<User> selectAllUsers() {
        return restTemplate.getForObject(APPLICATION_NAME+"/userAll", List.class);
    }

    @RequestMapping("/userOne")
    public User selectById() {
        return restTemplate.getForObject(APPLICATION_NAME+"/userOne", User.class);
    }

    /**
     * @author Seven Lee
     * @description
     *      脱离eureka实现ribbon的负载均衡
     *      java.lang.IllegalStateException: No instances available for localhost
     *          在ribbon没有eureka的时候，如果是测试环境，是不允许使用localhost，需要在hosts文件中配置ip和域名的映射ribbon01
     *          不但识别不了自己的localhost，还识别不了生产者的localhost，也需要把生产者在hosts文件中配置映射
     * @param []
     * @date 2019/8/24
     * @return com.aaa.lee.springcloud.model.User
     * @throws 
    **/
    @RequestMapping("/userById")
    public User selectOne() {
        // 1.通过loadBalancerClient对象获取到所有的服务提供者信息(从application.properties文件中配置的user-provider.ribbon.listOfServers)
        // serviceId:spring.application.name的值
        ServiceInstance serviceInstance = loadBalancerClient.choose("user-provider");
        // ServiceInstance:把随机出来的一台provider信息的封装
        // 2.获取到一个服务提供者的主机名(IP)
        String host = serviceInstance.getHost();
        System.out.println(host);
        // 3.获取到一个服务提供者的端口号
        int port = serviceInstance.getPort();
        System.out.println(port);
        String serviceId = serviceInstance.getServiceId();
        System.out.println(serviceId);
        // host+ip--->http:localhost:8081
        return restTemplate.getForObject("http://"+host+":"+port+"/userOne", User.class);
    }

}
