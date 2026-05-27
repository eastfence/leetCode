package com.xxxxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController    //提示类 告诉Spring 此类处理客户端web请求 将返回的结果返回给客户端
@SpringBootApplication()
// 元注解 包含了@SpringBootConfiguration、@EnableAutoConfiguration 和 @ComponentScan exclude用来排除某些自动装配类
public class MyApplication {

    @RequestMapping("/")
        //路由的功能 任何带有/路径的HTTP请求都应该被映射到home方法
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/name")
    String name() {
        return "My Name Is Robot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
