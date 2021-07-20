package com.clear2pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zlc
 * @Date 2021/7/16 - 13:09
 * @Descriptions 说点什么
 */
@SpringBootApplication
@EnableDiscoveryClient //开启注册中心，将服务注册到注册中心，默认是开启，所以可以不添加该注解
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
