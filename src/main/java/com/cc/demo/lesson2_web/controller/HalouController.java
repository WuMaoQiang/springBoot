package com.cc.demo.lesson2_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HalouController {
    @ResponseBody
    @RequestMapping("/hello2")
    public String hello2() {
        return "hello2";
    }

//只有写成Controller 才会返回html页面
    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
