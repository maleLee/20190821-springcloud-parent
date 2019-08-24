package com.aaa.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/8/23 10:45
 * @Description
 *      ribbon:
 *          负载均衡是实现在客户端的，和服务器没有关系
 *         一般情况下，ribbon需要和nginx一起使用，保证整个项目的性能和安全性
 *      负载均衡的配置:
 *         1.添加jar包
 *              <dependency>
 *                  <groupId>org.springframework.cloud</groupId>
 *                  <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
 *              </dependency>
 *         2.ribbon的出现可以和eureka一起使用，也可以脱离eureka使用
 *              可以单独存在，也可以和注册中心一起存在
 *         3.负载均衡的配置
 *              在RestTemplate类上添加注解@LoadBalance
 *              默认是轮询算法
 *         4.创建provider项目(至少创建三个)
 *         5.在consumer中的controller只访问了一个provider
 *              这种形式不能实现负载均衡
 *         6.如果实现负载均衡必须要去修改provider中application的name
 *              把所有的provider项目中spring.application.name=全部一致
 *         7.在consumer的controller中就不能配置localhost，配的是eureka中显示的Application(不需要添加端口号)
 *         8.如果需要更换负载均衡的算法，有两种实现方法
 *              通过Bean实现
 *                  在RestTemplate的配置中根据ribbon的rule规则配置各种算法实现(默认提供了7种，也可以自定义算法)
 *              通过application.properties实现
 *                  按照ribbon所提供的规则，在application.properties中进行配置
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationRun7082 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun7082.class, args);
    }
}
