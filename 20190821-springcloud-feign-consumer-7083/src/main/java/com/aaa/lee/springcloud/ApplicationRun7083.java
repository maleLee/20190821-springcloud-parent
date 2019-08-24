package com.aaa.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/8/24 9:52
 * @Description
 *      @EnableFeignClients和@MappScan注解比较相似，通过扫描的形式检测到所有的被@FeignClient注解所标识过的接口
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.aaa.lee.springcloud.api")
public class ApplicationRun7083 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun7083.class, args);
    }

}
