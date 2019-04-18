package com.cc.demo.lesson2_web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalouController {
    @RequestMapping("/hello2")
    public String hello2() {
        return "hello2";
    }
}
