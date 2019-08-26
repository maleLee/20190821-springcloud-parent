package com.aaa.lee.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/8/26 11:10
 * @Description
 **/
@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @RequestMapping("/getConfig")
    public String config() {
        return port+"---------"+datasourceUrl;
    }

}
