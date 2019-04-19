package com.cc.demo.lesson2_web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//用WebMvcConfigurerAdapter来扩展SpringMvc功能
// 1、标注Configuration注解
// 2、继承WebMvcConfigurerAdapter
// 3、不能标注 @EnableWebMvc（作用是全面接管springMVC）
@Configuration
public class MyAppConfig extends WebMvcConfigurerAdapter {
    //使用ctrl+o能显示所有可以重写的方法

    //第一种方法  视图解析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送mvc请求 来到了success
        registry.addViewController("mvc").setViewName("success");
        registry.addViewController("/").setViewName("index");

    }

    //第二种方法  视图解析器
    @Bean
    public WebMvcConfigurerAdapter getConfig() {

        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/index.html").setViewName("index");
            }
        };
    }


}
