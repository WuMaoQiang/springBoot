package com.cc.demo.lesson1.config;

import com.cc.demo.lesson1.service.helloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中； 容器中这个组件的默认id就是方法名
    @Bean
    public static helloService helloService222() {
        return new helloService();
    }
}
