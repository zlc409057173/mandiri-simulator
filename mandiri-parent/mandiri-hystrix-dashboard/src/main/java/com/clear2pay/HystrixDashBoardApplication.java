package com.clear2pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author zlc
 * @Date 2021/7/19 - 12:12
 * @Descriptions 熔断，断路器仪表盘，不做任何业务处理，可以直接通过http://localhost:port/ 在浏览器访问
 */
@SpringBootApplication
@EnableDiscoveryClient //开启注册中心
@EnableHystrixDashboard  //开启仪表盘应用
public class HystrixDashBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardApplication.class, args);
    }
}
