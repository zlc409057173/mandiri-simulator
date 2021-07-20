package com.clear2pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
//@MapperScan("com.clear2pay.dao") //掃描所有DAO接口,并创建DAO对象
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    /**
     * Sprintboot默认是通过jackson来转换JSON的，@JSONField(serialize = false)是FastJson的注解
     * Springboot使用jackson进行转JSON的时候并不会扫描这个注解。
     * @return
     */
//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters() {
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
//        // 空值特别处理
//        // WriteNullListAsEmpty 将Collection类型字段的字段空值输出为[]
//        // WriteNullStringAsEmpty 将字符串类型字段的空值输出为空字符串 “”
//        // WriteNullNumberAsZero 将数值类型字段的空值输出为0
//        // WriteNullBooleanAsFalse 将Boolean类型字段的空值输出为false
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteNullStringAsEmpty);
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        // 处理中文乱码问题
//        List<MediaType> fastMediaTypes = new ArrayList<>();
//        fastMediaTypes.add(MediaType.APPLICATION_JSON);
//        fastConverter.setSupportedMediaTypes(fastMediaTypes);
//        // 3.在convert中添加配置信息
//        return new HttpMessageConverters(fastConverter);
//    }
}
