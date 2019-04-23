package com.cc.demo.lesson2_web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//用WebMvcConfigurerAdapter来扩展SpringMvc功能
// 1、标注Configuration注解
// 2、继承WebMvcConfigurerAdapter
// 3、不能标注 @EnableWebMvc（作用是全面接管springMVC）
@Configuration
public class MyAppConfig extends WebMvcConfigurerAdapter {
    //使用ctrl+o能显示所有可以重写的方法,重写了添加视图映射方法


    //第一种方法
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //添加视图映射 ---->浏览器发送mvc请求 来到了success
        registry.addViewController("mvc").setViewName("success");
        //这个是映射到了templates里的index.html
        registry.addViewController("/").setViewName("index");
        //登录请求 重定向到dashboard防止表单重复提交
        registry.addViewController("/main.html").setViewName("dashboard");

    }


    //第二种方法
    @Bean
    public WebMvcConfigurerAdapter getConfig() {

        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/index.html").setViewName("index");
            }

//            //重写登录拦截器的 ,两个位置都可以
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html", "/", "/user/login");
//            }
        };

    }


}
