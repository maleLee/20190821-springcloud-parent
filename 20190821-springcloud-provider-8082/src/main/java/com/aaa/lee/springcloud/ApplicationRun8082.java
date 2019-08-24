package com.aaa.lee.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/8/23 11:03
 * @Description
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.aaa.lee.springcloud.mapper")
public class ApplicationRun8082 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8082.class, args);
    }

}
