package com.aaa.lee.springcloud.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019-08-21 11:56
 * @Description
 *      @LoadBalanced:开启客户端的负载均衡
 *      springcloud1.x中所需要实现:
 *          开启负载均衡后，默认就是轮询算法，不需要添加任何配置
 **/
@SpringBootApplication
public class RestConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
